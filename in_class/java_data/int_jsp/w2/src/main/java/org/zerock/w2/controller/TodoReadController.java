/**
 * Todo 목록에서 조회했던 Todo 번호들을 쿠키를 이용해서 보관한다.
 * 본 컨트롤러의 기능:
 * 1. 현재 요청(request)에 있는 모든 쿠키 중에 조회 목록 쿠키(viewTodos)를 찾아낸다.
 * 2. 특정한 tno가 쿠키의 내용물이 있는지 확인한다.
 * */
package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "todoReadController", value = "/todo/read")
@Log4j2
public class TodoReadController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        try {
            Long tno = Long.parseLong(req.getParameter("tno"));

            TodoDTO todoDTO = todoService.get(tno);

            // 데이터 담기
            req.setAttribute("dto", todoDTO);

            // 쿠키 찾기
            // viewTodos 이름의 쿠키를 찾는다.
            Cookie viewTodoCookie = findCookie(req.getCookies(), "viewTodos");
            String todoListStr = viewTodoCookie.getValue();
            boolean exist = false;

            if (todoListStr != null && todoListStr.indexOf(tno + "-") >= 0) {
                exist = true;
            }

            log.info("exist: " + exist);

            // 쿠키를 변경할 때에는 다시 경로나 유효시간을 세팅해야 한다.
            if (!exist) {
                todoListStr += tno + "-";
                viewTodoCookie.setValue(todoListStr);
                viewTodoCookie.setMaxAge(60 * 60 * 24);  // 쿠키 유지 시간 (24시간)
                viewTodoCookie.setPath("/");
                resp.addCookie(viewTodoCookie);
            }
            // 쿠키 찾기 끝
            req.getRequestDispatcher("/WEB-INF/todo/read.jsp").forward(req,resp);
        }
        catch (Exception e) {
            log.error(e.getMessage());
            throw new ServletException("read error");
        }
    }

    private Cookie findCookie(Cookie[] cookies, String cookieName) {

        Cookie targetCookie = null;

        // 쿠키의 내용물 검사
        if (cookies != null && cookies.length > 0) {

            for (Cookie ck:cookies) {

                if (ck.getName().equals(cookieName)) {
                    targetCookie = ck;
                    break;
                }
            }
        }

        // 조회한 적이 없는 번호라면 쿠키의 내용물을 갱신해서 브라우저로 보낸다.
        if (targetCookie == null) {
            targetCookie = new Cookie(cookieName, "");
            targetCookie.setPath("/");
            targetCookie.setMaxAge(60 * 60 * 24);  // 유효시간 : 60초 * 60 * 24 = 24시간
        }

        return targetCookie;
    }
}

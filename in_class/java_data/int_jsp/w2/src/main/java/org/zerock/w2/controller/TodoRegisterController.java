package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.TodoDTO;
import org.zerock.w2.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", value = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    // 입력 화면으로 포워드한다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        log.info("/todo/register GET ==============");

        HttpSession session = req.getSession();

        if (session.isNew()) {  // 기존에 JSESSIONID가 없는 새로운 사용자
            log.info("JSESSIONID 쿠키가 새로 만들어진 사용자");
            resp.sendRedirect("/login");
            return;
        }

        // JSESSIONID는 있지만 해당 세션 컨텍스트에 loginInfo라는 이름으로 저장된 객체가 업슨 경우
        if (session.getAttribute("loginInfo") == null) {
            log.info("로그인한 정보가 없는 사용자.");
            resp.sendRedirect("/login");
            return;
        }

        // 정상적인 경우라면 입력 화면으로
        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req,resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        // getParameter()로 TodoDTO를 구성한다.
        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"),DATEFORMATTER))
                .build();

        log.info("/todo/register POST ====================");
        log.info(todoDTO);

        // 최종적으로 TodoService의 register()를 호출한다.
        try {
            todoService.register(todoDTO);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        // 등록 완료 후에는 GET 방식으로 바로 목록 화면으로 리다이렉트한다.
        resp.sendRedirect("/todo/list");

    }  // doPost
}  // class

/**
 * 로그인 처리 컨트롤러
 * */

package org.zerock.w2.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.UUID;

@WebServlet("/login")
@Log4j2
public class LoginController extends HttpServlet {

    // 로그인 화면 출력
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        log.info("login get ...");

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    // 로그인 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        log.info("login post ...");

        // 사용자의 mid와 mpw를 수집하고 이를 이용해서 문자열을 구성한다.
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");


        // 자동 로그인 여부 처리
        // 'auto'라는 이름으로 체크박스에서 전송되는 값이 'on'인지 확인한다.
        String auto = req.getParameter("auto");

        boolean rememberMe = ((auto != null) && auto.equals("on"));

        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);

            // rememberMe가 true이면 java.util의 UUID를 이용해서 임의의 번호를 생성한다.
            if (rememberMe) {
                String uuid = UUID.randomUUID().toString();

                MemberService.INSTANCE.updateUuid(mid, uuid);
                memberDTO.setUuid(uuid);

                // 쿠키 생성 및 전송
                Cookie rememberCookie = new Cookie("remember-me", uuid);
                rememberCookie.setMaxAge(60 * 60 * 24 * 7);  // 유효기간 = 1주일
                rememberCookie.setPath("/");

                resp.addCookie(rememberCookie);
                // 쿠키 생성 및 전송 끝
            }
            // 자동 로그인 끝

            // MemberService 연동
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);  // 정상적으로 로그인 된 경우 객체를 'loginInfo' 이름으로 저장한다.
            resp.sendRedirect("/todo/list");

        }
        catch (Exception e) {  // 예외가 발생하는 경우
            resp.sendRedirect("/login?result=error");  // result는 문제가 발생했다는 사실을 같이 전달하는 파라미터
        }

    }

/* 자동 로그인 처리 전 doost(
    // 로그인 처리
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        log.info("login post ...");

        // 사용자의 mid와 mpw를 수집하고 이를 이용해서 문자열을 구성한다.
        String mid = req.getParameter("mid");
        String mpw = req.getParameter("mpw");

        // MemberService 연동
        try {
            MemberDTO memberDTO = MemberService.INSTANCE.login(mid, mpw);
            HttpSession session = req.getSession();
            session.setAttribute("loginInfo", memberDTO);  // 정상적으로 로그인 된 경우 객체를 'loginInfo' 이름으로 저장한다.
            resp.sendRedirect("/todo/list");
        }
        catch (Exception e) {  // 예외가 발생하는 경우
            resp.sendRedirect("/login?result=error");  // result는 문제가 발생했다는 사실을 같이 전달하는 파라미터
        }

    }
*/
}

/**
 * 로그인 처리 컨트롤러
 * */

package org.zerock.w2.controller;

import lombok.extern.java.Log;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
@Log
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

        String str = mid+mpw;

        // 구성된 문자열을 HttpSession이 이용하는 공간에 저장한다.
        HttpSession session = req.getSession();

        session.setAttribute("loginInfo", str);

        resp.sendRedirect("/todo/list");
    }
}

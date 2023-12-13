package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/todo/*"})  // /todo/...로 시작하는 모든 경로에 대해서 필터링을 시도한다.
@Log4j2
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.info("Login check filter ...");

        // 로그인 여부를 체크한다.
        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        HttpSession session = req.getSession();

        if (session.getAttribute("loginInfo") == null) {
            resp.sendRedirect("/login");
            return;
        }
        // 로그인 여부 체크 끝

        chain.doFilter(request, response);  // 다음 필터나 목적지로 갈 수 있도록 실행한다.
    }
}

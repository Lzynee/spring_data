package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter(urlPatterns = {"/todo/*"})  // /todo/...로 시작하는 모든 경로에 대해서 필터링을 시도한다.
@Log4j2
public class LoginCheckFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.info("Login check filter ...");

        chain.doFilter(request, response);  // 다음 필터나 목적지로 갈 수 있도록 실행한다.
    }
}

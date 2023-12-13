/**
 * UTF-8 처리 필터
 * 한글이 깨진 상태로 저장되는 문제 해결
 * */
package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter(urlPatterns = {"/*"})  // 모든 경로에 적용되도록 설정
@Log4j2
public class UTF8Filter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        log.info("UTF8 filter ...");

        HttpServletRequest req = (HttpServletRequest) request;

        req.setCharacterEncoding("UTF-8");

        chain.doFilter(request, response);
    }
}

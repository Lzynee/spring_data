package org.zerock.w2.filter;

import lombok.extern.log4j.Log4j2;
import org.zerock.w2.dto.MemberDTO;
import org.zerock.w2.service.MemberService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

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

        // 객체가 HttpSession에는 없고, 쿠키에 UUID 값만 있는 경우:
        // session에 lognInfo 값이 없다면
        // 쿠키를 체크
        Cookie cookie = findCookie(req.getCookies(), "remember-me");  // 모든 쿠키 중에서 remember-me 이름의 쿠키를 검색

        // 세션에도 없고 쿠키도 없다면 그냥 로그인으로
        if (cookie == null) {
            resp.sendRedirect("/login");
            return;
        }

        // 쿠키가 존재하는 상황이라면
        log.info("cookie는 존재하는 상황");
        //uuid값
        String uuid = cookie.getValue();

        // 쿠키의 value를 이용해서
        // MemberService를 통해 MemberDTO를 구성
        try {
            // 데이터 확인
            MemberDTO memberDTO = MemberService.INSTANCE.getByUUID(uuid);

            log.info("쿠키의 값으로 조회한 사용자 정보: " + memberDTO);

            if (memberDTO == null) {
                throw new Exception("Cookie value is not valid");
            }
            // 회원 정보를 세션에 추가
            session.setAttribute("loginInfo", memberDTO);
            chain.doFilter(request, response);  // 다음 필터나 목적지로 갈 수 있도록 실행한다.
        }
        catch (Exception e) {
            e.printStackTrace();
            resp.sendRedirect("/login");
        }
    }

    // findCookie()
    private Cookie findCookie(Cookie[] cookies, String name) {

        if (cookies == null || cookies.length == 0) {
            return null;
        }

        Optional<Cookie> result = Arrays.stream(cookies)
                .filter(ck -> ck.getName().equals(name))
                .findFirst();

        return result.isPresent()?result.get():null;
    }
}

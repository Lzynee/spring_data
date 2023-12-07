/**
 * IntelliJ Ultimate에서 스프링 시작하기
 * 작성일 : 2023-12-07
 * */
package org.zerock.w1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// @WebServlet(name = "${서블릿이름}", value = "${경로}")
// 서블릿 이름을 생략할 수 있지만,
// spring을 사용할 경우 경로를 여러 개 설정할 수 있기 때문에
// 이름을 밝혀 두는 것이 좋다.
@WebServlet(name = "myServlet", value = "/my")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        resp.setContentType("text/html");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>MyServlet</h1>");
        out.println("</body></html>");
    }
}

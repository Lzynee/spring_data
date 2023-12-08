/**
 * init()과 destroy(), doGet() 호출하기
 * */

package org.zerock.w1;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SampleServlet", urlPatterns = "/sample")
public class SampleServlet extends HttpServlet {

    // this의 결과로 출력되는 값이 모두 동일한 객체이다.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("doGet...." + this);
    }

    // destroy 메소드는 톰캣을 종료할 때 작동한다.
    @Override
    public void destroy() {
        System.out.println("destroy...");
    }

    // init 메소드는 /sample을 처음 호출할 때 실행된다.
    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("init(ServletConfig)...");
    }
}

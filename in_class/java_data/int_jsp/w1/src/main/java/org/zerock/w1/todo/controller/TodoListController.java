/**
 * GET 방식만 처리
 * TodoService에서 제공하는 List<TodoDTO>를 가져와서 JSP로 전달한다.
 * */

package org.zerock.w1.todo.controller;

import org.zerock.w1.todo.dto.TodoDTO;
import org.zerock.w1.todo.service.TodoService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "todoListController", urlPatterns = "/todo/list")
public class TodoListController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        System.out.println("/todo/list");

        // 서비스 객체 생성 및 메소드 선언 후 추가한 내용 =====
        List<TodoDTO> dtoList = TodoService.INSTANCE.getList();

        req.setAttribute("list", dtoList);
        // =============================================

        req.getRequestDispatcher("/WEB-INF/todo/list.jsp")
                .forward(req, resp);
    }
}

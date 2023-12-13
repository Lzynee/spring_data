package org.zerock.jdbcex.controller;

import lombok.extern.log4j.Log4j2;
import org.zerock.jdbcex.dto.TodoDTO;
import org.zerock.jdbcex.service.TodoService;

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

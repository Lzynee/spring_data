package com.springmvc.controller;

import com.springmvc.domain.Book;
import com.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
@RequestMapping(value = "/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping
    public String requestsBookList(Model model){
        List<Book> list =  bookService.getAllBookList();
        model.addAttribute("bookList", list);
        return "books";
    }

    @GetMapping(value = "/all")  // 수정
    public ModelAndView requestsAllBooks(){

        ModelAndView modelAndView = new ModelAndView();
        List<Book> list =  bookService.getAllBookList();
        modelAndView.addObject("bookList", list);
        modelAndView.setViewName("books");
        return modelAndView;
    }

    // 도서 분야와 일치하는 목록 출력 메서드 추가
    @GetMapping("/{category}")  // 경로 변수로 category 추가
    public String requestBooksByCategory(@PathVariable("category")  // 경로 변수에 대한 매개변수 이름 재정의
                                             String bookCategory, Model model) {

        // 매개변수와 일치하는 도서 목록을 서비스 객체에서 가져와 booksByCategory에 저장한다.
        List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
        model.addAttribute("bookList", booksByCategory);  // booksByCategory 값을 모델 속성 bookList에 저장
        return "books";  // book.jsp 뷰로 반환
    }

    @GetMapping("/book")
    public String requestBookById(@RequestParam("id") String bookId, Model model) {

        Book bookById = bookService.getBookById(bookId);
        model.addAttribute("book", bookById);
        return "book";
    }

    @GetMapping("/filter/{bookFilter}")
    public String requestBooksByFilter(
            @MatrixVariable(pathVar = "bookFilter")
            Map<String, List<String>> bookFilter, Model model) {

        Set<Book> booksByFilter = bookService.getBookListByFilter(bookFilter);
        model.addAttribute("bookList", booksByFilter);
        return "books";
    }
}

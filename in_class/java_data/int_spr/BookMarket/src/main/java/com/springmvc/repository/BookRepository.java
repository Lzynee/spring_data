package com.springmvc.repository;

import com.springmvc.domain.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAllBookList();

    // 도서 분야와 일치하는 목록 출력 메서드 추가
    List<Book> getBookListByCategory(String category);

}

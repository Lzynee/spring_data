package com.springmvc.service;

import com.springmvc.domain.Book;

import java.util.List;

public interface BookService {
    List<Book> getAllBookList();
    List<Book> getBookListByCategory(String category);
}

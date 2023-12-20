package com.springmvc.service;

import com.springmvc.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookService {
    List<Book> getAllBookList();
    List<Book> getBookListByCategory(String category);
    Book getBookById(String bookId);
    Set<Book> getBookListByFilter(Map<String, List<String>> filter);
}

package com.springmvc.repository;

import com.springmvc.domain.Book;

import java.util.List;

public interface BookRepository {

    List<Book> getAllBookList();

}

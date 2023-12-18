package com.springmvc.service;

import com.springmvc.domain.Book;
import com.springmvc.repository.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepositoryImpl bookRepository;

    @Override
    public List<Book> getAllBooList() {
        return bookRepository.getAllBookList();
    }
}

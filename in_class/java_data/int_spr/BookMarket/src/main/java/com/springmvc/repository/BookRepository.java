package com.springmvc.repository;

import com.springmvc.domain.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface BookRepository {

    List<Book> getAllBookList();
    // 도서 분야와 일치하는 목록 출력 메서드 추가
    List<Book> getBookListByCategory(String category);
    // RequestParam -> 특정 ID를 가진 도서의 상세 정보 출력 메서드 추가
    Book getBookById(String bookId);
    // 매트릭스 변수 값과 일치하는 도서 목록 출력 메서드 추가 (@MatrixVariable)
    Set<Book> getBookListByFilter(Map<String, List<String>> filter);

}

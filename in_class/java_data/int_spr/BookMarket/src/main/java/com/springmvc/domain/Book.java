package com.springmvc.domain;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class Book {
    private String bookId;         // 도서 ID
    private String name;           // 도서명
    private int unitPrice;         // 가격
    private String author;         // 저자
    private String description;    // 설명
    private String publisher;      // 출판사
    private String category;       // 분류
    private int unitsInStock;      // 재고 수
    private String releaseDate;    // 출판일(월/년)
    private String condition;      // 신규 도서 또는 중고 도서 또는 전자책

    public Book(String bookId, String name, int unitPrice) {
        this.bookId = bookId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

}

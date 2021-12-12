package com.example.library.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String bookName;
    @Enumerated(EnumType.STRING)
    private BookStatus bookStatus = BookStatus.ALLOWED;

    public Book(String bookName, BookStatus bookStatus) {
        this.bookName = bookName;
        this.bookStatus = bookStatus;
    }
}

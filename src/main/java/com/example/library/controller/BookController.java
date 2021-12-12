package com.example.library.controller;

import com.example.library.dto.request.BookRequest;
import com.example.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;

    @RequestMapping("/add")
    public void addBook(@RequestBody BookRequest bookRequest) {
        bookService.addBook(bookRequest);
    }
}
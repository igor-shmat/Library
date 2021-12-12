package com.example.library.init;

import com.example.library.dao.BookRepository;
import com.example.library.dto.request.BookRequest;
import com.example.library.entity.BookStatus;
import com.example.library.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(1)
@Component
public class InitBook implements CommandLineRunner {

    private BookService bookService;
    private BookRepository bookRepository;

    public InitBook(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (bookRepository.count() > 0) {
            return;
        }
        BookRequest book1 = new BookRequest("book1", BookStatus.ALLOWED);
        BookRequest book2 = new BookRequest("book2", BookStatus.ALLOWED);
        BookRequest book3 = new BookRequest("book3", BookStatus.ALLOWED);
        BookRequest book4 = new BookRequest("book4", BookStatus.ALLOWED);
        BookRequest book5 = new BookRequest("book5", BookStatus.ALLOWED);
        BookRequest book6 = new BookRequest("book6", BookStatus.ALLOWED);
        bookService.addBooks(List.of(book1, book2, book3, book4, book5, book6));
    }
}

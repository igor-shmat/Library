package com.example.library.service;

import com.example.library.converter.BookRequestToBook;
import com.example.library.dao.BookRepository;
import com.example.library.dto.request.BookRequest;
import com.example.library.entity.Book;
import com.example.library.entity.BookStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRequestToBook bookRequestToBook;
    private final BookRepository bookRepository;

    public BookService(BookRequestToBook bookRequestToBook, BookRepository bookRepository) {
        this.bookRequestToBook = bookRequestToBook;
        this.bookRepository = bookRepository;
    }

    public void addBook(BookRequest bookRequest) {
        bookRepository.save(new Book(bookRequest.getName(), BookStatus.ALLOWED));
    }

    public Book findBook(String bookName) {
        return bookRepository.findByBookName(bookName);
    }

    public void addBooks(List<BookRequest> bookRequests) {
        bookRepository.saveAll(bookRequests.stream().map(bookRequestToBook::convert).collect(Collectors.toList()));
    }

    public void save(Book book) {
        bookRepository.save(book);
    }
}

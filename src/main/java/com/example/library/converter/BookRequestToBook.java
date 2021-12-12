package com.example.library.converter;

import com.example.library.dto.request.BookRequest;
import com.example.library.entity.Book;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class BookRequestToBook implements Converter<BookRequest, Book> {
    @Override
    public Book convert(BookRequest source) {
        Book book = new Book();
        book.setBookName(source.getName());
        book.setBookStatus(source.getBookStatus());
        return book;
    }
}

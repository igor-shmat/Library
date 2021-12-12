package com.example.library.service;

import com.example.library.dao.UserRepository;
import com.example.library.dto.request.BookGetRequest;
import com.example.library.dto.request.UserRequest;
import com.example.library.entity.Book;
import com.example.library.entity.BookStatus;
import com.example.library.entity.Users;
import com.example.library.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final BookService bookService;

    public UserService(UserRepository userRepository, BookService bookService) {
        this.userRepository = userRepository;
        this.bookService = bookService;
    }

    public void addUser(UserRequest userRequest) {
        userRepository.save(new Users(userRequest.getFio()));
    }

    public Users findUser(String fio) {
        return userRepository.findByFio(fio);

    }

    public void addUsers(List<UserRequest> userRequests) {
        userRepository.saveAll(userRequests.stream().map(one -> new Users(one.getFio())).collect(Collectors.toList()));
    }

    public void getBook(BookGetRequest bookGetRequest) {
        Users users = findUser(bookGetRequest.getFio());
        if (users == null) {
            throw new NotFoundException("Незарегистрированый пользователь");
        }
        Book book = bookService.findBook(bookGetRequest.getBookName());
        if (book == null) {
            throw new NotFoundException("Книги нет в наличии");
        }
        if (book.getBookStatus().equals(BookStatus.NOT_ALLOWED)) {
            throw new NotFoundException("Книга занята другим пользователем");
        }
        users.getBooks().add(book);
        book.setBookStatus(BookStatus.NOT_ALLOWED);
        userRepository.save(users);
    }

    public void back(BookGetRequest bookGetRequest) {
        Users users = findUser(bookGetRequest.getFio());
        Book book = bookService.findBook(bookGetRequest.getBookName());
        List<Book> bookss = new ArrayList<>();
        List<Book> books = users.getBooks();
        for (Book book1 : books) {
            if (!book1.getBookName().equals(bookGetRequest.getBookName())) {
                bookss.add(book1);
            }
        }
        users.setBooks(bookss);
        book.setBookStatus(BookStatus.ALLOWED);
        userRepository.save(users);
        bookService.save(book);
    }
}

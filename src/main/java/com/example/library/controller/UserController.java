package com.example.library.controller;

import com.example.library.dto.request.BookGetRequest;
import com.example.library.dto.request.UserRequest;
import com.example.library.entity.Users;
import com.example.library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    public void addUser(@RequestBody UserRequest userRequest) {
        userService.addUser(userRequest);
    }

    @PostMapping("/getBook")
    public void getBook(@RequestBody BookGetRequest bookGetRequest) {
        userService.getBook(bookGetRequest);
    }

    @PostMapping("/getBookBack")
    public void back(@RequestBody BookGetRequest bookGetRequest) {
        userService.back(bookGetRequest);
    }

    @GetMapping("/findUser")
    public Users findUser(@RequestParam String fio) {
        return userService.findUser(fio);
    }
}

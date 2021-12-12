package com.example.library.init;

import com.example.library.dao.UserRepository;
import com.example.library.dto.request.UserRequest;
import com.example.library.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Order(2)
@Component
public class InitUser implements CommandLineRunner {

    private final UserService userService;
    private final UserRepository userRepository;

    public InitUser(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.count() > 0) {
            return;
        }
        UserRequest user1 = new UserRequest("user1");
        UserRequest user2 = new UserRequest("user2");
        UserRequest user3 = new UserRequest("user3");
        UserRequest user4 = new UserRequest("user4");
        UserRequest user5 = new UserRequest("user5");
        UserRequest user6 = new UserRequest("user6");
        userService.addUsers(List.of(user1, user2, user3, user4, user5, user6));
    }
}

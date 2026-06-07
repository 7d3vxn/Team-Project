package org.example.geektext.controller;


import org.example.geektext.model.User;
import org.example.geektext.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")

public class UserController {

    private final UserRepository userRepository;

   public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/{username}")
    public User findByUsername(@PathVariable String username) {
       return userRepository.findByUsername(username);
    }
}


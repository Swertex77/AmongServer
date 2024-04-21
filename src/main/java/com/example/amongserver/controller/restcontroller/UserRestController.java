package com.example.amongserver.controller.restcontroller;

import com.example.amongserver.domain.entity.User;
import com.example.amongserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService service;


    @PostMapping("/user")
    public User createUser(@RequestBody User user) {
        return service.add(user);
    }
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return service.getAll();
    }
    @GetMapping("/user/{id}")
    public User getById(@PathVariable long id) {
        return service.getById(id);
    }
}

package com.example.AmongServer.controller.restcontroller;

import com.example.AmongServer.domain.entity.User;
import com.example.AmongServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
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

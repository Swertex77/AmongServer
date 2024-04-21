package com.example.amongserver.service;

import com.example.amongserver.domain.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);
    List<User> getAll();
    User getById(long id);
}

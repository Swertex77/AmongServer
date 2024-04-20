package com.example.AmongServer.service;

import com.example.AmongServer.domain.entity.User;

import java.util.List;

public interface UserService {
    User add(User user);
    List<User> getAll();
    User getById(long id);
}

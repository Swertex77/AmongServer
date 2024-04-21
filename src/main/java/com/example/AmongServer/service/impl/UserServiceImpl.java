package com.example.AmongServer.service.impl;

import com.example.AmongServer.domain.entity.StartCoordinates;
import com.example.AmongServer.domain.entity.User;
import com.example.AmongServer.reposirory.StartCoordinatesRepository;
import com.example.AmongServer.reposirory.UserRepository;
import com.example.AmongServer.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repository;


    @Override
    public User add(User user) {
        user.setReady(false);
        user.setImposter(false);
        return repository.save(user);
    }

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public User getById(long id) {
        Optional<User> user = repository.findById(id);
        if(!user.isPresent()) throw new RuntimeException("User with ID " + id + " not found");
        return user.get();
    }
}

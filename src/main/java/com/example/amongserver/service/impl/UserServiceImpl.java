package com.example.amongserver.service.impl;

import com.example.amongserver.domain.entity.StartCoordinates;
import com.example.amongserver.domain.entity.User;
import com.example.amongserver.dto.GameStateDto;
import com.example.amongserver.reposirory.UserRepository;
import com.example.amongserver.service.UserService;
import lombok.RequiredArgsConstructor;
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
    public GameStateDto getGameStateDto() {
// TODO: xxxxxxxx
        return null;
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

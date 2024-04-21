package com.example.amongserver.service.impl;

import com.example.amongserver.domain.entity.StartCoordinates;
import com.example.amongserver.reposirory.StartCoordinatesRepository;
import com.example.amongserver.service.StartCoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StartCoordinatesServiceImpl implements StartCoordinatesService {

    private final StartCoordinatesRepository repository;

    @Autowired
    public StartCoordinatesServiceImpl(StartCoordinatesRepository startCoordinatesRepository) {
        this.repository = startCoordinatesRepository;
    }

    @Override
    public StartCoordinates add(StartCoordinates startCoordinates) {
        return repository.save(startCoordinates);
    }

    @Override
    public List<StartCoordinates> getAll() {
        return repository.findAll();
    }

    @Override
    public StartCoordinates getById(long id) {
        Optional<StartCoordinates> startCoordinates = repository.findById(id);
        if(!startCoordinates.isPresent()) throw new RuntimeException("User with ID " + id + " not found");
        return startCoordinates.get();
    }
}

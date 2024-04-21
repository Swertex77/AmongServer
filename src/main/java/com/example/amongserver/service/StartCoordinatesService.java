package com.example.amongserver.service;

import com.example.amongserver.domain.entity.StartCoordinates;

import java.util.List;

public interface StartCoordinatesService{
    StartCoordinates add(StartCoordinates startCoordinates);
    List<StartCoordinates> getAll();
    StartCoordinates getById(long id);
}

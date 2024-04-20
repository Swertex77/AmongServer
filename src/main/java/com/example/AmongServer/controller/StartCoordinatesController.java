package com.example.AmongServer.controller;



import com.example.AmongServer.domain.StartCoordinates;
import com.example.AmongServer.service.StartCoordinatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StartCoordinatesController {
    private final StartCoordinatesService service;

    @Autowired
    public StartCoordinatesController(StartCoordinatesService service, SimpMessagingTemplate simpleMessageTemplate) {
        this.service = service;
    }

    @PostMapping("/startCoordinates")
    public StartCoordinates createUser(@RequestBody StartCoordinates startCoordinates) {
        return service.add(startCoordinates);
    }
    @GetMapping("/startCoordinates")
    public List<StartCoordinates> getAllUsers() {
        return service.getAll();
    }
    @GetMapping("/startCoordinates/{id}")
    public StartCoordinates getById(@PathVariable long id) {
        return service.getById(id);
    }



}

package com.example.AmongServer.script;

import com.example.AmongServer.domain.StartCoordinates;
import com.example.AmongServer.reposirory.StartCoordinatesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class StartCoordinatesScript implements CommandLineRunner {
    private final StartCoordinatesRepository repository;

    private final List<StartCoordinates> coordinatesList = new ArrayList<StartCoordinates>();

    @Autowired
    public StartCoordinatesScript(StartCoordinatesRepository repository) {
        this.repository = repository;
    }

    public void addStartingCoordinates() {
        coordinatesList.add(new StartCoordinates(1, 55.686896, 37.504162));
        coordinatesList.add(new StartCoordinates(2, 55.686916, 37.496937));
        coordinatesList.add(new StartCoordinates(3, 55.679843, 37.507568));
        coordinatesList.add(new StartCoordinates(4, 55.690882, 37.504051));
        coordinatesList.add(new StartCoordinates(5, 55.683772, 37.497699));

        repository.saveAll(coordinatesList);
    }

    @Override
    public void run(String... args) {
        addStartingCoordinates();
    }
}

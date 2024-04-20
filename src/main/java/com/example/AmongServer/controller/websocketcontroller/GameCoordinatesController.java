package com.example.AmongServer.controller.websocketcontroller;

import com.example.AmongServer.domain.entity.StartCoordinates;
import com.example.AmongServer.reposirory.StartCoordinatesRepository;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.example.AmongServer.constant.Const.*;

@RestController
@RequestMapping(LINK_CHAT)
@AllArgsConstructor
public class GameCoordinatesController {
    private final SimpMessagingTemplate simpleMessageTemplate;
    private final StartCoordinatesRepository startCoordinatesRepository;

    @MessageMapping("/coordinates")
    public void coordinatesSocket(StartCoordinates coordinates) {
        System.out.println("34 id=" + coordinates.getId() + " x=" + coordinates.getLatitude() + " y=" + coordinates.getLongitude() + "sfd");
        if (coordinates.isCompleted()) {
            // Находим объект StartCoordinates по его id
            Optional<StartCoordinates> optionalCoordinates = startCoordinatesRepository.findById(coordinates.getId());

            // Если объект найден
            if (optionalCoordinates.isPresent()) {
                StartCoordinates existingCoordinates = optionalCoordinates.get();

                // Обновляем значение поля coordinates
                existingCoordinates.setCompleted(true);

                // Сохраняем изменения в базе данных
                startCoordinatesRepository.save(existingCoordinates);
            }
            List<StartCoordinates> startCoordinatesList = startCoordinatesRepository.findAll();
            List<StartCoordinates> trueConditionCoordinates = new ArrayList<>();

            for (StartCoordinates startCoordinates : startCoordinatesList) {
                if (!startCoordinates.isCompleted()) {
                    trueConditionCoordinates.add(startCoordinates);
                }
            }

            sendCoordinatesToClients(trueConditionCoordinates);
        }
    }

    private void sendCoordinatesToClients(List<StartCoordinates> coordinatesList) {
        simpleMessageTemplate.convertAndSend(COORDINATES_TOPIC, coordinatesList);
    }

}

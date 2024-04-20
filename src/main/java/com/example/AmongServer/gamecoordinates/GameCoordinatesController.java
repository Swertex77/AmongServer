package com.example.AmongServer.gamecoordinates;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.AmongServer.constant.Const.COORDINATES_TOPIC;
import static com.example.AmongServer.constant.Const.LINK_CHAT;

@RestController
@RequestMapping(LINK_CHAT)
public class GameCoordinatesController {
    private final SimpMessagingTemplate simpleMessageTemplate;

    public GameCoordinatesController(SimpMessagingTemplate simpleMessageTemplate) {
        this.simpleMessageTemplate = simpleMessageTemplate;
    }

    @MessageMapping("/coordinates")
    public void coordinatesSocket(GemaCoordinates coordinates) {
        System.out.println("RECEIVED: id=" + coordinates.getId() + " x=" + coordinates.getLatitude() + " y=" + coordinates.getLongitude() + "sfd" + coordinates.isCondition());
        sendMessageToGemaCoordinates(coordinates); // Отправим сообщения другим пользователям
    }
    private void sendMessageToGemaCoordinates(GemaCoordinates coordinates) {
        simpleMessageTemplate.convertAndSend(COORDINATES_TOPIC, coordinates);
    }
}

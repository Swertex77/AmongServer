package com.example.AmongServer.gamecoordinates;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static com.example.AmongServer.constant.Const.*;

@RestController
@RequestMapping(LINK_CHAT)
public class GameCoordinatesController {
    private final SimpMessagingTemplate simpleMessageTemplate;

    public GameCoordinatesController(SimpMessagingTemplate simpleMessageTemplate) {
        this.simpleMessageTemplate = simpleMessageTemplate;
    }
    @MessageMapping("/coordinates")
    public void coordinatesSocket(GemaCoordinates coordinates) {
        System.out.println("34 id=" + coordinates.getId() + " x=" + coordinates.getLatitude() + " y=" + coordinates.getLongitude() + "sfd");
        sendMessageToGemaCoordinates(coordinates); // Отправим сообщения другим пользователям
    }
    private void sendMessageToGemaCoordinates(GemaCoordinates coordinates) {
        List<GemaCoordinates> myList = new ArrayList<>();
        myList.add(new GemaCoordinates(1,43, 342, true));
        myList.add(new GemaCoordinates(2,43, 234, false));
        simpleMessageTemplate.convertAndSend(COORDINATES_TOPIC, myList);
    }

}

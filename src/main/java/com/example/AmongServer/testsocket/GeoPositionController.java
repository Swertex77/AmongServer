package com.example.AmongServer.testsocket;

import com.example.AmongServer.domain.StartCoordinates;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.AmongServer.constant.Const.GEOPOS_TOPIC;
import static com.example.AmongServer.constant.Const.LINK_CHAT;

@RestController
@RequestMapping(LINK_CHAT)
public class GeoPositionController {
    private final SimpMessagingTemplate simpleMessageTemplate;

    public GeoPositionController(SimpMessagingTemplate simpleMessageTemplate) {
        this.simpleMessageTemplate = simpleMessageTemplate;
    }

    @MessageMapping("/sock")
    public void geoPosSocket(StartCoordinates res) {
        System.out.println("RECEIVED: id=" + res.getId() + " latitude=" + res.getLatitude() + " longitude=" + res.getLongitude());
        sendMessageToUsers(res); // отправим сообщения другим пользователям
    }

    private void sendMessageToUsers(StartCoordinates message) {
        // если сообщение отправляется в общий чат
        simpleMessageTemplate.convertAndSend(GEOPOS_TOPIC, message);
    }
}

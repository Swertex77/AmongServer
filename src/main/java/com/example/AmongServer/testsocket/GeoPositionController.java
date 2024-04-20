package com.example.AmongServer.testsocket;


import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import static com.example.AmongServer.constant.Const.*;

@RestController
@RequestMapping(LINK_CHAT)
public class GeoPositionController {
    private final SimpMessagingTemplate simpleMessageTemplate;

    public GeoPositionController(SimpMessagingTemplate simpleMessageTemplate) {
        this.simpleMessageTemplate = simpleMessageTemplate;
    }

    @MessageMapping("/sock")
    public void geoPosSocket(GeoPosition res) {
        System.out.println("RECEIVED: id=" + res.getId() + " latitude=" + res.getLatitude() + " longitude=" + res.getLongitude());
        sendMessageToGeoPosition(res); // отправим сообщения другим пользователям
    }

    private void sendMessageToGeoPosition(GeoPosition message) {
        // если сообщение отправляется в общий чат
        simpleMessageTemplate.convertAndSend(GEOPOS_TOPIC, message);
    }
}

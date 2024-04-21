//package com.example.AmongServer.invalid;
//
//import com.example.AmongServer.domain.entity.StartCoordinates;
//import org.springframework.messaging.handler.annotation.MessageMapping;
//import org.springframework.messaging.handler.annotation.SendTo;
//import org.springframework.stereotype.Controller;
//
//@Controller
//public class WebSocketController {
//    @MessageMapping("/coordinates") // Обработка сообщений от клиента
//    @SendTo("/topic/coordinates") // Рассылка сообщений всем подписчикам
//    public StartCoordinates handleCoordinates(StartCoordinates coordinates) {
//        //TODO: Обработка координат и, при необходимости, выполнение дополнительных действий
//
//        return coordinates;
//    }
//}

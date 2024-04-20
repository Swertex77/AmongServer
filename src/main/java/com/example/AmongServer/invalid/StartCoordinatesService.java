//package com.example.AmongServer.invalid;
//
//import com.example.AmongServer.domain.StartCoordinates;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Service;
//
//@Service
//public class StartCoordinatesService {
//    private final SimpMessagingTemplate messagingTemplate;
//
//    @Autowired
//    public StartCoordinatesService(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }
//
//    public void addCoordinates(StartCoordinates coordinates) {
//        //TODO: Логика сохранения координат в базе данных
//
//        //TODO: Отправка координат всем подписчикам
//        messagingTemplate.convertAndSend("/topic/coordinates", coordinates);
//    }
//}

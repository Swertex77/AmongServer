package com.example.AmongServer.controller.websocketcontroller;


import com.example.AmongServer.domain.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.AmongServer.constant.Const.LINK_CHAT;
import static com.example.AmongServer.constant.Const.USER_TOPIC;

@RestController
@RequestMapping(LINK_CHAT)
@AllArgsConstructor
public class UserController {
    private final SimpMessagingTemplate simpleMessageTemplate;



    @MessageMapping("/user")
    public void geoPosSocket(User user) {
        System.out.println("User");
        sendMessageToUser(user); // отправим сообщения другим пользователям
    }

    private void sendMessageToUser(User user) {
        // если сообщение отправляется в общий чат
        simpleMessageTemplate.convertAndSend(USER_TOPIC, user);
    }
}

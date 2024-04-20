package com.example.AmongServer.testsocket;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.example.AmongServer.constant.Const.CHAT_TOPIC;
import static com.example.AmongServer.constant.Const.LINK_CHAT;

@RestController
@RequestMapping(LINK_CHAT)
public class ChatController {
    private final SimpMessagingTemplate simpleMessageTemplate;

    public ChatController(SimpMessagingTemplate simpleMessageTemplate) {
        this.simpleMessageTemplate = simpleMessageTemplate;
    }

    @MessageMapping("/sock")
    public void chatSocket(ChatSocketMessage res) {
        sendMessageToUsers(res); // отправим сообщения другим пользователям
    }

    private void sendMessageToUsers(ChatSocketMessage message) {
        if (message.getReceiver() != null) {
            // если сообщение отправляется в приватный чат
            simpleMessageTemplate.convertAndSendToUser(message.getReceiver(), CHAT_TOPIC, message);
        } else {
            // если сообщение отправляется в общий чат
            simpleMessageTemplate.convertAndSend(CHAT_TOPIC, message);
        }
    }
}

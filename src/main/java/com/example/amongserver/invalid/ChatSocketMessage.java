//package com.example.AmongServer.invalid;
//
//
//import com.fasterxml.jackson.annotation.JsonInclude;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
//import com.fasterxml.jackson.databind.annotation.JsonSerialize;
//import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
//import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
//
//import java.time.LocalDateTime;
//
//@JsonInclude(JsonInclude.Include.NON_NULL)
//public class ChatSocketMessage {
//    private String text;
//    private String author;
//    @JsonDeserialize(using = LocalDateTimeDeserializer.class)
//    @JsonSerialize(using = LocalDateTimeSerializer.class)
//    private LocalDateTime datetime;
//    private String receiver;
//
//    public ChatSocketMessage(String text, String author, LocalDateTime datetime, String receiver) {
//        this.text = text;
//        this.author = author;
//        this.datetime = datetime;
//        this.receiver = receiver;
//    }
//
//    public String getText() {
//        return text;
//    }
//
//    public void setText(String text) {
//        this.text = text;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public LocalDateTime getDatetime() {
//        return datetime;
//    }
//
//    public void setDatetime(LocalDateTime datetime) {
//        this.datetime = datetime;
//    }
//
//    public String getReceiver() {
//        return receiver;
//    }
//
//    public void setReceiver(String receiver) {
//        this.receiver = receiver;
//    }
//}

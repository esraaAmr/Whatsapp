package com.example.whatsapp2.Models;

public class ChatTextModel {
    private String message;
    private String senderId;

    public ChatTextModel(String message, String senderId) {
        this.message = message;
        this.senderId = senderId;
    }

    public ChatTextModel() {

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }
}

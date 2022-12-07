package com.example.whatsapp2.Models;

public class ChatsModel {
    private int chatImage;
    private String chatName;
    private String lastMsg;
    private String lastMsgTime;

    public ChatsModel() {
    }

    public ChatsModel(int chatImage, String chatName, String lastMsg, String lastMsgTime) {
        this.chatImage = chatImage;
        this.chatName = chatName;
        this.lastMsg = lastMsg;
        this.lastMsgTime = lastMsgTime;
    }

    public int getChatImage() {
        return chatImage;
    }

    public void setChatImage(int chatImage) {
        this.chatImage = chatImage;
    }

    public String getChatName() {
        return chatName;
    }

    public void setChatName(String chatName) {
        this.chatName = chatName;
    }

    public String getLastMsg() {
        return lastMsg;
    }

    public void setLastMsg(String lastMsg) {
        this.lastMsg = lastMsg;
    }

    public String getLastMsgTime() {
        return lastMsgTime;
    }

    public void setLastMsgTime(String lastMsgTime) {
        this.lastMsgTime = lastMsgTime;
    }
}

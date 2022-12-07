package com.example.whatsapp2.Models;

public class CallsModel {
    private int callsProf;
    private String callsName;
    private String callsTime;
    private int callImg;

    public CallsModel(int callsProf, String callsName, String callsTime, int callImg) {
        this.callsProf = callsProf;
        this.callsName = callsName;
        this.callsTime = callsTime;
        this.callImg = callImg;
    }

    public int getCallsProf() {
        return callsProf;
    }

    public void setCallsProf(int callsProf) {
        this.callsProf = callsProf;
    }

    public String getCallsName() {
        return callsName;
    }

    public void setCallsName(String callsName) {
        this.callsName = callsName;
    }

    public String getCallsTime() {
        return callsTime;
    }

    public void setCallsTime(String callsTime) {
        this.callsTime = callsTime;
    }

    public int getCallImg() {
        return callImg;
    }

    public void setCallImg(int callImg) {
        this.callImg = callImg;
    }
}

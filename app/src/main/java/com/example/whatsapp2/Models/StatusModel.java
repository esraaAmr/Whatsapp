package com.example.whatsapp2.Models;

public class StatusModel {
    private int statusProf;
    private String statusName;
    private String statusTime;

    public StatusModel() {
    }

    public StatusModel(int statusProf, String statusName, String statusTime) {
        this.statusProf = statusProf;
        this.statusName = statusName;
        this.statusTime = statusTime;
    }

    public int getStatusProf() {
        return statusProf;
    }

    public void setStatusProf(int statusProf) {
        this.statusProf = statusProf;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusTime() {
        return statusTime;
    }

    public void setStatusTime(String statusTime) {
        this.statusTime = statusTime;
    }
}

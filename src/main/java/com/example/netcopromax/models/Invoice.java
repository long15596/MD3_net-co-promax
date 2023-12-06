package com.example.netcopromax.models;

import java.time.LocalTime;

public class Invoice {
    private int id;
    private String comName;
    private String username;
    private double payment;
    private LocalTime endTime;

    public Invoice(int id, Com com, User user, double payment, LocalTime endTime) {
        this.id = id;
        this.comName = com.getName();
        this.username = user.getName();
        this.payment = payment;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public double getPayment() {
        return payment;
    }

    public void setPayment(double payment) {
        this.payment = payment;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }
}

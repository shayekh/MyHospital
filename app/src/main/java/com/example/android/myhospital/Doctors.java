package com.example.android.myhospital;

public class Doctors {

    private int id;
    private String name,details,appoinment,phone,email;

    public Doctors() {

    }

    public Doctors(int id, String name, String details, String appoinment, String phone, String email) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.appoinment = appoinment;
        this.phone = phone;
        this.email = email;
    }

    public Doctors(String name, String details, String appoinment, String phone, String email) {
        this.name = name;
        this.details = details;
        this.appoinment = appoinment;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDetails() {
        return details;
    }

    public String getAppoinment() {
        return appoinment;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }
}

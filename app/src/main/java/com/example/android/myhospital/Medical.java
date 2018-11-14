package com.example.android.myhospital;

public class Medical {

    private int id;
    private String name,details,date,image;

    public Medical(int id, String name, String details, String date, String image) {
        this.id = id;
        this.name = name;
        this.details = details;
        this.date = date;
        this.image = image;
    }

    public Medical(String name, String details, String date, String image) {
        this.name = name;
        this.details = details;
        this.date = date;
        this.image = image;
    }

    public Medical()
    {

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

    public String getDate() {
        return date;
    }

    public String getImage() {
        return image;
    }
}

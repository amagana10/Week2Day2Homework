package com.example.week2day2homework;

import java.io.Serializable;

public class Car implements Serializable {
    private String make;
    private String model;
    private String year;
    private String titleStatus;
    private String color;
    private String engine;
    private String transmission;

    public Car(String make, String model, String year, String titleStatus, String color, String engine, String transmission) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.titleStatus = titleStatus;
        this.color = color;
        this.engine = engine;
        this.transmission = transmission;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getYear() {
        return year;
    }

    public String getTitleStatus() {
        return titleStatus;
    }

    public String getColor() {
        return color;
    }

    public String getEngine() {
        return engine;
    }

    public String getTransmission() {
        return transmission;
    }
}

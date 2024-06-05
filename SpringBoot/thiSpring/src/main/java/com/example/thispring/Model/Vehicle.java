package com.example.thispring.Model;

public class Vehicle {
    private int id;
    private String name;
    private String model;
    private String yearOfManufacture;
    private String color;

    public Vehicle(int id, String name, String model, String yearOfManufacture, String color) {
        this.id = id;
        this.name = name;
        this.model = model;
        this.yearOfManufacture = yearOfManufacture;
        this.color = color;
    }
    public Vehicle(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(String yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

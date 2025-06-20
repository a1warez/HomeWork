package ru.test.homework.model;

public class Car {
    private int id;
    private String brand;
    private String color;
    private int year;
    private double price;

    public Car() {
    }

    public Car(int id, String brand, String color, int year, double price) {
        this.id = id;
        this.brand = brand;
        this.color = color;
        this.year = year;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}

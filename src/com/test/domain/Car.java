package com.test.domain;

public class Car {

    private String carId;
    private String carModel;
    private String carBrand;
    private long carBasePrice;
    private boolean isCarAvailable;

    //creating constructor for class car
    public Car(String carId, String carModel, String carBrand, long carBasePrice) {
        this.carId = carId;
        this.carModel = carModel;
        this.carBrand = carBrand;
        this.carBasePrice = carBasePrice;
        this.isCarAvailable = true;
    }

    //default constructor
    public Car() {

    }

    //getters

    public String getCarId() {
        return carId;
    }

    public String getCarModel() {
        return carModel;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public long getCarBasePrice() {
        return carBasePrice;
    }

    //method to calculate total price

    public long calculatePrice(int rentalDays) {
        return carBasePrice * rentalDays;
    }

    public boolean isCarAvailable() {
        return isCarAvailable;
    }

    public void rent() {
        isCarAvailable = false;
    }

    public void carReturn() {
        isCarAvailable = true;
    }
}

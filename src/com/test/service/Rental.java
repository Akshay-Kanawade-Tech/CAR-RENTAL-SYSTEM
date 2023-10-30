package com.test.service;

import com.test.domain.Car;
import com.test.domain.Customer;

/*this class is combo of customer class and car class*/
public class Rental {

    private Car car;
    private Customer customer;
    private int days;


    //constructor

    public Rental(Car car, Customer customer, int days) {
        this.car = car;
        this.customer = customer;
        this.days = days;
    }

    //getters

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    public int getDays() {
        return days;
    }
}

package com.test.main;

import com.test.dao.ClassCarRentals;
import com.test.domain.Car;

public class Main {
    public static void main(String[] args) {
        ClassCarRentals classCarRentals = new ClassCarRentals();

        Car car1 = new Car("C001", "Camry", "Toyota", 100);
        Car car2 = new Car("C002", "Harrier", "Tata", 500);
        Car car3 = new Car("C003", "Thar", "Mahindra", 500);

        classCarRentals.addCar(car1);
        classCarRentals.addCar(car2);
        classCarRentals.addCar(car3);
        classCarRentals.menu();
    }
}
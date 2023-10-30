package com.test.dao;

import com.test.service.Rental;
import com.test.domain.Car;
import com.test.domain.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClassCarRentals {


    //it will store my car's data
    private List<Car> cars;
    //store my customer data
    private List<Customer> customers;

    //it will store my rental data

    private List<Rental> rentals;

    // three arraylist declared above now i am goint to declared that arraylist as blank

    public ClassCarRentals() {
        //it will take data as input
        cars = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
    }

    // adding data of car customer and rental in arralist using .add method of arraylist

    public void addCar(Car car) {
        cars.add(car);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }


    // customer in renting car
    public void rentCar(Car car, Customer customer, int days) {
        if (car.isCarAvailable()) {
            car.rent();

            rentals.add(new Rental(car, customer, days));
        } else {
            System.out.println("Car is not available for rent!!");
        }
    }

    //customer returning the car
    public void returnCar(Car car) {
        //which car he is going to return
        car.carReturn();
        Rental rentalToRemove = null;
        for (Rental rental : rentals) {
            if (rental.getCar() == car) {
                rentalToRemove = rental;
                break;
            }
        }

        if (rentalToRemove != null) {
            rentals.remove(rentalToRemove);
            System.out.println("Car returned successfully!!");
        } else {
            System.out.println("Car was not rented!!");
        }
    }


    //interface for customer on terminal
    public void menu() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== car rental system =====");
            System.out.println("1.Rent a Car");
            System.out.println("2.Return a Car");
            System.out.println("3.Exit");
            System.out.println("Enter Your choice:");

            int choice = scanner.nextInt();
            scanner.nextLine();     //consume newline

            if (choice == 1) {
                System.out.println("\n----Rent a Car----\n");
                System.out.println("Enter Your Name:");
                String customerName = scanner.nextLine();

                System.out.println("Available Cars->");
                for (Car car : cars) {
                    if (car.isCarAvailable()) {
                        System.out.println(car.getCarId() + " - " + car.getCarBrand() + " - " + car.getCarModel());
                    }
                }

                System.out.print("\nEnter Car Id that you want to Rent->");
                String carId = scanner.nextLine();


                System.out.print("\nEnter Number of days to Rent Car:");
                int rentaldays = scanner.nextInt();
                scanner.nextLine();

                Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
                addCustomer(newCustomer);

                Car selectedCar = null;

                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && car.isCarAvailable()) {
                        selectedCar = car;
                        break;
                    }
                }

                if (selectedCar != null) {
                    double totalPrice = selectedCar.calculatePrice(rentaldays);
                    System.out.println("\n== Rental Information==\n");

                    /*System.out.println("Customer Id: " +newCustomer.getCustAdharCardNo());
                    System.out.println("Customer Name: " + newCustomer.getCustName());*/
                    System.out.println("Car: " + selectedCar.getCarBrand() + " " + selectedCar.getCarModel());
                    System.out.println("rental Days: " + rentaldays);
                    System.out.println("Total Price:" + totalPrice);

                    System.out.println("\nConfirm Rental (Y/N): ");
                    String confirm = scanner.nextLine();

                    if (confirm.equalsIgnoreCase("Y")) {
                        rentCar(selectedCar, newCustomer, rentaldays);

                        System.out.println("Car Rented successfully!!\n");
                    } else {
                        System.out.println("Rental Cancelled!!");
                    }
                } else {
                    System.out.println("\nInvalid car selection or car not available for rent!!");
                }
            } else if (choice == 2) {
                System.out.println("\n===retrun a Car===\n");
                System.out.println("Enter car id you want to return:");
                String carId = scanner.nextLine();

                Car carToReturn = null;
                for (Car car : cars) {
                    if (car.getCarId().equals(carId) && !car.isCarAvailable()) {
                        carToReturn = car;
                        break;
                    }
                }
                if (carToReturn != null) {
                    Customer customer = null;
                    for (Rental rental : rentals) {
                        if (rental.getCar() == carToReturn) {
                            customer = rental.getCustomer();
                            break;
                        }
                    }
                    if (customer != null) {
                        returnCar(carToReturn);
                        System.out.println("Car return successfully!!" + customer.getCustName());
                    } else {
                        System.out.println("Car is not rented or rental information is missing!!");
                    }
                } else {
                    System.out.println("Invalid car id");
                }
            } else if (choice == 3) {
                break;
            } else {
                System.out.println("Invalid choice..Please enter valid choice!!");
            }
        }
        System.out.println("\nThank You for using Car Rental system!!");

    }
}

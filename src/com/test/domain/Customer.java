package com.test.domain;

public class Customer {
    private String custName;
    private String custAdharCardNo;
    private long custMobileNumber;

    //constructor

    public Customer(String custName, String custAdharCardNo, long custMobileNumber) {
        this.custName = custName;
        this.custAdharCardNo = custAdharCardNo;
        this.custMobileNumber = custMobileNumber;
    }

    public Customer(String custAdharCardNo, String customerName) {

    }


    //getters

    public String getCustName() {
        return custName;
    }

    public String getCustAdharCardNo() {
        return custAdharCardNo;
    }

    public long getCustMobileNumber() {
        return custMobileNumber;
    }
}



package com.riztech.sharedprefrence;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String destination;
    private long salary;
    private String address;

    public Employee(String name, String destination, long salary, String address) {
        this.name = name;
        this.destination = destination;
        this.salary = salary;
        this.address = address;
    }

    public Employee() {
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

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

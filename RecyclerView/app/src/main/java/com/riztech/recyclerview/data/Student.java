package com.riztech.recyclerview.data;

public class Student {
    String name;
    String address;
    String phoneNumber;
    String className;
    String collegeName;

    public Student(String name, String address, String phoneNumber, String className, String collegeName) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.className = className;
        this.collegeName = collegeName;
    }

    public Student() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }
}

package com.example.question2;

public class Friend {
    private int id;
    private String name;
    private String address;
    private String phoneNumber;

    public Friend(String name, int id, String address, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public Friend(int anInt, String string, String cursorString, String phoneNumber) {
        id = 0;
        name = null;
        address = null;
        this.phoneNumber = null;
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
}

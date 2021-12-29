package org.sample;

import java.util.Date;

public class Contact {

    private String name;
    private String phoneNumber;
    private String email;

    private final Date createdDate = new Date();

    public Contact() {}

    public Contact(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public String toString() {
        return String.format("name: %s  phone number: %s  email: %s  date created: %s",
            this.name, this.phoneNumber, this.email, this.createdDate);
    }
}

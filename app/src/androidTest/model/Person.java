package com.classroom.model;

import java.util.UUID;

public abstract class Person {
    private String firstname;
    private String surname;
    private String uuid;

    public Person(String firstname, String surname){
        this.uuid = UUID.randomUUID().toString();
        this.firstname = firstname;
        this.surname = surname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
}

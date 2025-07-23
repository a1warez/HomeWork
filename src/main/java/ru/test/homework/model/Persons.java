package ru.test.homework.model;


import java.util.Objects;

public class Persons {
    private String name;
    private String position;
    private String email;
    private String phoneNumber;
    private String aboutMe;


    public Persons() {
    }

    public Persons(String name, String position, String email, String phoneNumber, String aboutMe) {
        this.name = name;
        this.position = position;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.aboutMe = aboutMe;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persons persons = (Persons) o;
        return Objects.equals(name, persons.name) && Objects.equals(position, persons.position) && Objects.equals(email, persons.email) && Objects.equals(phoneNumber, persons.phoneNumber) && Objects.equals(aboutMe, persons.aboutMe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position, email, phoneNumber, aboutMe);
    }

    @Override
    public String toString() {
        return "Persons{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", aboutMe='" + aboutMe + '\'' +
                '}';
    }
}
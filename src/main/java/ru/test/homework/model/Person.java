package ru.test.homework.model;

public class Person {
    private int id;
    private String surname;
    private String lastname;
    private int age;

    public Person(int id, String surname, String lastname, int age) {
        this.id = id;
        this.surname = surname;
        this.lastname = lastname;
        this.age = age;

    }

    public Person() {
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getLastname() {
        return lastname;
    }

    public int getAge() {
        return age;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setId(int id) {
        this.id = id;
    }
}

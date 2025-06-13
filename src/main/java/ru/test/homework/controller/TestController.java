package ru.test.homework.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.test.homework.model.Person;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/test")
public class TestController {

    List<Person> personss;
    {
        System.out.println("Create");
        personss = new ArrayList<>();
    }


    @GetMapping("/add")
    public boolean addPerson(int id ,String surname, String lastname, int age) {
        return  personss.add(new Person(id, surname, lastname, age));
    }

    @GetMapping("/getAll")
    public List<Person> getPerson(){
        return personss;
    }

    @GetMapping("/getById")
    public Person getById(int id) {
        for (Person person : personss) {
            if (person.getId() == id) {
                return person;
            }
        }
        return null;
    }

    @GetMapping("/updateById")
    public Person updateById(int id, Person updatedPerson) {
        for (int i = 0; i < personss.size(); i++) {
            if (personss.get(i).getId() == id) {
                updatedPerson.setId(id);
                personss.set(i, updatedPerson);
                return updatedPerson;
            }
        }
        return null;
    }

    @GetMapping("/deleteById")
    public boolean deleteById(int id) {
        for (int i = 0; i < personss.size(); i++) {
            if (personss.get(i).getId() == id) {
                personss.remove(i);
                return true;
            }
        }
        return false;
    }
}

package ru.test.homework.dz10;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "Subjects")
public class Subjects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "Name", unique = true)
    private String name;
}
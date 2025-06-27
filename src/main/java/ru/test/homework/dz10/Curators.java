package ru.test.homework.dz10;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "Curators")

public class Curators {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "Name")
    private String name;

    @NotBlank(message = "Surname cannot be blank")
    @Column(name = "Surname")
    private String surname;
}
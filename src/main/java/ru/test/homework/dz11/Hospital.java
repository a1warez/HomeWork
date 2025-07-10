package ru.test.homework.dz11;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Hospitals")
public class Hospital {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String city;

    @ManyToMany(mappedBy = "hospitals")
    private List<Doctor> doctors;
}
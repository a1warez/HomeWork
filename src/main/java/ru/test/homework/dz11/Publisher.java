package ru.test.homework.dz11;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Publishers")
public class Publisher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String country;

    @OneToMany(mappedBy = "publisher", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Magazine> magazines;
}
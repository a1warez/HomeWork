package ru.test.homework.dz11;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Libraries")
public class Library {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;

    @OneToMany(mappedBy = "library", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookCopy> bookCopies;
}
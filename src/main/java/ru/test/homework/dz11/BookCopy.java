package ru.test.homework.dz11;

import jakarta.persistence.*;

@Entity
@Table(name = "BookCopies")

public class BookCopy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String isbn;
    private String condition;

    @ManyToOne
    @JoinColumn(name = "library_id")
    private Library library;
}
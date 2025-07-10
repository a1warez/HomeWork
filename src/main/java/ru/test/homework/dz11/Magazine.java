package ru.test.homework.dz11;

import jakarta.persistence.*;

@Entity
@Table(name = "Magazines")
public class Magazine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private Integer issueNumber;

    @ManyToOne
    @JoinColumn(name = "publisher_id")
    private Publisher publisher;
}
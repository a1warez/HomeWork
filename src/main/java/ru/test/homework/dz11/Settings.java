package ru.test.homework.dz11;

import jakarta.persistence.*;

@Entity
@Table(name = "Settings")
public class Settings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private boolean darkMode;
    private String language;

    @OneToOne(mappedBy = "settings")
    private User user;
}
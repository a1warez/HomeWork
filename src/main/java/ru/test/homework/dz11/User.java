package ru.test.homework.dz11;


import jakarta.persistence.*;

@Entity
@Table(name = "Users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "settings_id")
    private Settings settings;
}

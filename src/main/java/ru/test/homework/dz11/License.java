package ru.test.homework.dz11;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "Licenses")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String licenseNumber;
    private LocalDate issuedAt;

    @OneToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
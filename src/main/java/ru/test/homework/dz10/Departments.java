package ru.test.homework.dz10;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Departments")
public class Departments {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @NotNull(message = "Financing cannot be null")
    @DecimalMin(value = "0.0", message = "Financing must be greater than or equal to 0")
    @Column(name = "Financing")
    private Double financing;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "Name", unique = true)
    private String name;
}
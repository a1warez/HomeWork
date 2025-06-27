package ru.test.homework.dz10;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;


@Entity
@Table(name = "Teachers")
public class Teachers {

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

    @NotNull(message = "Salary cannot be null")
    @DecimalMin(value = "0.0", inclusive = false, message = "Salary must be greater than 0")  // inclusive = false means it has to be greater than 0
    @Column(name = "Salary")
    private Double salary;
}
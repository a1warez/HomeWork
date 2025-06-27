package ru.test.homework.dz10;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "Groups")
public class Groups {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @NotBlank(message = "Name cannot be blank")
    @Column(name = "Name", unique = true)
    private String name;

    @NotNull(message = "Year cannot be null")
    @Min(value = 1, message = "Year must be between 1 and 5")
    @Max(value = 5, message = "Year must be between 1 and 5")
    @Column(name = "Year")
    private int year;
}

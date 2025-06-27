package ru.test.homework.dz10;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;


@Entity
@Table(name = "Lectures")
public class Lectures {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int id;

    @NotBlank(message = "LectureRoom cannot be blank")
    @Column(name = "LectureRoom")
    private String lectureRoom;
}
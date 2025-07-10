package ru.test.homework.dz11;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "TeachingAssignments")
public class TeachingAssignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startDate;
    private Integer hoursPerWeek;

    @ManyToOne
    @JoinColumn(name = "teacher_id")
    private Teacher teacher;

    @ManyToOne
    @JoinColumn(name = "classroom_id")
    private Classroom classroom;
}
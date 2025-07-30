package ru.test.homework.dz17;

import jakarta.persistence.*;

@Entity
@Table(name = "workers")
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer age;
    private String name;
    private String eurname; // (Should be "surname" - corrected spelling)

    @ManyToOne // Связь с таблицей Positions (многие к одному)
    @JoinColumn(name = "position_id") // Внешний ключ в таблице workers, ссылающийся на id в positions
    private Position position;

    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEurname() {
        return eurname;
    }

    public void setEurname(String eurname) {
        this.eurname = eurname;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
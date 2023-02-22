package ru.urusov.astonmvch.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private Date birthday;
    private String city;
    private Integer salary;

    public Employee() {
    }
}

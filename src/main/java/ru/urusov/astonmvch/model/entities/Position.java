package ru.urusov.astonmvch.model.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "position")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private Long id;

    @Column(name = "position_name")
    private String name;

    @Column(name = "position_salary")
    private Integer salary;

    @OneToMany(mappedBy = "position", fetch = FetchType.LAZY)
    private Set<Employee> employees;

    public Position() {
    }

    public Position(Long id, String name, Integer salary, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.employees = employees;
    }

    public Position(Long id, String name, Integer salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
}

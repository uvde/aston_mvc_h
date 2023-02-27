package ru.urusov.astonmvch.model.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @Column(name = "project_name")
    private String name;

    @ManyToMany(mappedBy = "projects")
    private Set<Employee> employees;

    public Project() {
    }

    public Project(Long id, String name, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.employees = employees;
    }

    public Project(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Project(String name) {
        this.name = name;
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

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }
}

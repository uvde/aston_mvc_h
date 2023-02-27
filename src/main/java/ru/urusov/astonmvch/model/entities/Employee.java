package ru.urusov.astonmvch.model.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Long id;

    @Column(name = "employee_name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "employee_birthday")
    private Date birthday;

    @Column(name = "employee_city")
    private String city;

    @ManyToOne
    @JoinColumn(name = "position_id_fk")
    @BatchSize(size = 3)
    @LazyToOne(LazyToOneOption.NO_PROXY)
    private Position position;

    @ManyToMany
    @JoinTable(name = "employee_project",
        joinColumns = @JoinColumn(name = "employee_id"),
        inverseJoinColumns = @JoinColumn(name = "project_id"))
    private Set<Project> projects;


    public Employee() {
    }

    public Employee(String name, Date birthday, String city) {
        this.name = name;
        this.birthday = birthday;
        this.city = city;
    }

    public Employee(Long id, String name, Date birthday, String city, Position position, Set<Project> projects) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.city = city;
        this.position = position;
        this.projects = projects;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                ", city='" + city + '\'' +
                '}';
    }
}

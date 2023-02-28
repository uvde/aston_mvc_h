package ru.urusov.astonmvch.model.dto;

import ru.urusov.astonmvch.model.entities.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GetPositionByIdResponse {
    private Long id;
    private String name;
    private Integer salary;
    private List<Employee> employees;

    public GetPositionByIdResponse(Long id, String name, Integer salary, Set<Employee> employees) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.employees = new ArrayList<>(employees);
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {

        this.employees = new ArrayList<>(employees);
    }
}

package ru.urusov.astonmvch.dao;

import ru.urusov.astonmvch.model.entities.Employee;

import java.util.List;

public interface EmployeesDao {

    List<Employee> getAllEmployees();
    Employee getById(Long id);
    void saveEmployee(Employee employee);
    void deleteById(Long id);
    void updateEmployeeById(Employee employee);
}

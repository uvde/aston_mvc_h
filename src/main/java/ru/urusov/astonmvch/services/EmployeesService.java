package ru.urusov.astonmvch.services;

import ru.urusov.astonmvch.model.dto.EmployeeDto;

import java.util.List;

public interface EmployeesService {

    List<EmployeeDto> getAllEmployees();
    EmployeeDto getById(Long id);
    Long saveEmployee(EmployeeDto employeeDto);
    void deleteById(Long id);
    void updateEmployeeById(EmployeeDto employeeDto);
}

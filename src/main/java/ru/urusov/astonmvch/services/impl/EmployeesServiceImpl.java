package ru.urusov.astonmvch.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.urusov.astonmvch.dao.EmployeesDao;
import ru.urusov.astonmvch.model.dto.EmployeeDto;
import ru.urusov.astonmvch.services.EmployeesService;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class EmployeesServiceImpl implements EmployeesService {

    private final EmployeesDao employeesDao;

    public EmployeesServiceImpl(EmployeesDao employeesDao) {
        this.employeesDao = employeesDao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeeDtoList = new ArrayList<>();
        employeesDao.getAllEmployees()
                .forEach(e -> employeeDtoList
                        .add(new EmployeeDto(e.getId(), e.getName(), e.getBirthday(), e.getCity(), e.getSalary())));
        return employeeDtoList;
    }

    @Override
    public EmployeeDto getById(Long id) {
        return null;
    }

    @Override
    public Long saveEmployee(EmployeeDto employeeDto) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void updateEmployeeById(EmployeeDto employeeDto) {

    }
}

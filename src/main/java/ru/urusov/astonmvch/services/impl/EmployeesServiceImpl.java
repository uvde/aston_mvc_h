package ru.urusov.astonmvch.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.urusov.astonmvch.dao.EmployeesDao;
import ru.urusov.astonmvch.model.dto.EmployeeDto;
import ru.urusov.astonmvch.model.entities.Employee;
import ru.urusov.astonmvch.model.entities.Position;
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
                        .add(new EmployeeDto(e.getId(),
                                e.getName(),
                                e.getBirthday(),
                                e.getCity(),
                                e.getPosition().getSalary(),
                                e.getPosition().getName())));
        return employeeDtoList;
    }

    @Override
    @Transactional
    public void saveEmployee(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setName(employeeDto.getName());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setCity(employeeDto.getCity());
        Position position = new Position();
        position.setId(employeeDto.getPositionId());
        employee.setPosition(position);
        employeesDao.saveEmployee(employee);
    }

    @Override
    @Transactional(readOnly = true)
    public EmployeeDto getById(Long id) {
        Employee employee = employeesDao.getById(id);
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.setId(employee.getId());
        employeeDto.setName(employee.getName());
        employeeDto.setBirthday(employee.getBirthday());
        employeeDto.setCity(employee.getCity());
        employeeDto.setPositionId(employee.getPosition().getId());
        employeeDto.setPosition(employee.getPosition().getName());
        return employeeDto;
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        employeesDao.deleteById(id);
    }

    @Override
    @Transactional
    public void updateEmployeeById(EmployeeDto employeeDto) {
        Employee employee = new Employee();
        employee.setId(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setBirthday(employeeDto.getBirthday());
        employee.setCity(employeeDto.getCity());
        Position position = new Position();
        position.setId(employeeDto.getPositionId());
        employee.setPosition(position);
        employeesDao.updateEmployeeById(employee);
    }
}

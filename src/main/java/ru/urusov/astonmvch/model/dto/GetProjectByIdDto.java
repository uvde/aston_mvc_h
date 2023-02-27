package ru.urusov.astonmvch.model.dto;

import java.util.List;

public class GetProjectByIdDto {
    private Long id;
    private String projectName;
    private List<EmployeeDto> employeeDtoList;

    public GetProjectByIdDto() {
    }

    public GetProjectByIdDto(Long id, String projectName, List<EmployeeDto> employeeDtoList) {
        this.id = id;
        this.projectName = projectName;
        this.employeeDtoList = employeeDtoList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<EmployeeDto> getEmployeeDtoList() {
        return employeeDtoList;
    }

    public void setEmployeeDtoList(List<EmployeeDto> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }
}

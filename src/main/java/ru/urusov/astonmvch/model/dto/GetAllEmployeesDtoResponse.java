package ru.urusov.astonmvch.model.dto;

import java.util.List;

public class GetAllEmployeesDtoResponse {

    private List<EmployeeDto> employeeDtoList;
    private List<PositionDto> positionDtoList;

    public GetAllEmployeesDtoResponse() {
    }

    public GetAllEmployeesDtoResponse(List<EmployeeDto> employeeDtoList, List<PositionDto> positionDtoList) {
        this.employeeDtoList = employeeDtoList;
        this.positionDtoList = positionDtoList;
    }

    public List<EmployeeDto> getEmployeeDtoList() {
        return employeeDtoList;
    }

    public void setEmployeeDtoList(List<EmployeeDto> employeeDtoList) {
        this.employeeDtoList = employeeDtoList;
    }

    public List<PositionDto> getPositionDtoList() {
        return positionDtoList;
    }

    public void setPositionDtoList(List<PositionDto> positionDtoList) {
        this.positionDtoList = positionDtoList;
    }
}

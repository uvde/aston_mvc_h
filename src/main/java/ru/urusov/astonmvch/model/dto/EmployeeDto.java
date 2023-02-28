package ru.urusov.astonmvch.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Pattern;
import java.util.Date;
import java.util.Objects;

public class EmployeeDto {

    private Long id;
    @Pattern(regexp = "[a-zA-Z]")
    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
    private String city;
    private Integer salary;
    private String position;
    private Long positionId;

    public EmployeeDto() {
    }

    public EmployeeDto(Long id, String name, Date birthday, String city, Integer salary, String position) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.city = city;
        this.salary = salary;
        this.position = position;
    }

    public EmployeeDto(Long id, String name, Date birthday, String city, Integer salary, String position, Long positionId) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.city = city;
        this.salary = salary;
        this.position = position;
        this.positionId = positionId;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeDto that = (EmployeeDto) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(birthday, that.birthday) && Objects.equals(city, that.city) && Objects.equals(salary, that.salary) && Objects.equals(position, that.position) && Objects.equals(positionId, that.positionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, birthday, city, salary, position, positionId);
    }
}

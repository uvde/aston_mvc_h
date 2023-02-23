package ru.urusov.astonmvch.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class EmployeeDto {

        private Long id;
        private String name;
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private Date birthday;
        private String city;
        private Integer salary;

        public EmployeeDto() {
        }

        public EmployeeDto(Long id, String name, Date birthday, String city, Integer salary) {
            this.id = id;
            this.name = name;
            this.birthday = birthday;
            this.city = city;
            this.salary = salary;
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

}

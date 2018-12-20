package com.application.td1.model;

import java.util.List;
import java.util.stream.Collector;

public class EmployeesEntityDTO {
    private String firstName;
    private String lastName;
    private DepartmentsEntity departmentId;

    public EmployeesEntityDTO() {

    }

    public EmployeesEntityDTO(String firstName, String lastName, DepartmentsEntity departmentId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DepartmentsEntity getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(DepartmentsEntity departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "EmployeesEntityDTO{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentName=" + departmentId.getDepartmentName() +
                '}';
    }


}

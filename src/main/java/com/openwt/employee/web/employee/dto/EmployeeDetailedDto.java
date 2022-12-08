package com.openwt.employee.web.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class EmployeeDetailedDto {
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;
    private List<SalaryDto> salaries;
    private List<CurrentDepartmentEmployeeDto> currentDepartmentEmployee;
}
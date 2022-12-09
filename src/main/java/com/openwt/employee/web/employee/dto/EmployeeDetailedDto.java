package com.openwt.employee.web.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class EmployeeDetailedDto {
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate hireDate;
    private List<SalaryDto> salaries;
    private List<CurrentDepartmentEmployeeDto> currentDepartments;
}

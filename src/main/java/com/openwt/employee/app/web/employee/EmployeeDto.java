package com.openwt.employee.app.web.employee;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeDto {
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;
}

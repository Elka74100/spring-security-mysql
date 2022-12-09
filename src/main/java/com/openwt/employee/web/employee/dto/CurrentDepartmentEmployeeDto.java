package com.openwt.employee.web.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CurrentDepartmentEmployeeDto {
    private String deptNo;
    private LocalDate fromDate;
    private LocalDate toDate;
}

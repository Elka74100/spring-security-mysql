package com.openwt.employee.web.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class CurrentDepartmentEmployeeDto {
    private String deptNo;
    private Date fromDate;
    private Date toDate;
}

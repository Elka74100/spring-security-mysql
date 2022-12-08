package com.openwt.employee.web.employee.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class SalaryDto {
    private Integer salary;
    private Date fromDate;
    private Date toDate;
}

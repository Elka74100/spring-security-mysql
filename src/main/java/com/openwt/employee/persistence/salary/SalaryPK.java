package com.openwt.employee.persistence.salary;

import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;
@Embeddable
@Getter
public class SalaryPK implements Serializable {
    private Long empNo;
    private LocalDate fromDate;
}
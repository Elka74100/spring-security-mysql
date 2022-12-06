package com.openwt.employee.app.persistence.salary;

import jakarta.persistence.Embeddable;
import lombok.Data;


import java.io.Serializable;
import java.util.Date;
@Embeddable
@Data
public class SalaryPK implements Serializable {
    private Long empNo;
    private Date fromDate;
}
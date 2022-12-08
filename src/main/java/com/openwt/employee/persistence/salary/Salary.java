package com.openwt.employee.persistence.salary;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.openwt.employee.persistence.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@Table(name= "salaries")
public class Salary {
    @EmbeddedId
    private SalaryPK salaryPK;
    private Integer salary;
    private Date toDate;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="empNo", insertable=false, updatable=false)
    private Employee employee;
}
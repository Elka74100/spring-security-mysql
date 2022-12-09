package com.openwt.employee.persistence.departement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.openwt.employee.persistence.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name= "dept_emp")
public class DepartmentEmployee {
    @EmbeddedId
    private DepartmentPK departmentPK;
    private LocalDate fromDate;
    private LocalDate toDate;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="empNo", insertable=false, updatable=false)
    private Employee employee;
}

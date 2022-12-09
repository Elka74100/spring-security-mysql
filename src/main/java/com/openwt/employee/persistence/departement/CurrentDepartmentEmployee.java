package com.openwt.employee.persistence.departement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.openwt.employee.persistence.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.time.LocalDate;

@Entity
@Immutable
@Getter
@Table(name= "current_dept_emp")
public class CurrentDepartmentEmployee {
    @EmbeddedId
    private DepartmentPK departmentPK;
    private LocalDate fromDate;
    private LocalDate toDate;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="empNo", insertable=false, updatable=false)
    private Employee employee;
}

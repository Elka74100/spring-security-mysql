package com.openwt.employee.app.persistence.departement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.openwt.employee.app.persistence.employee.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import org.hibernate.annotations.Immutable;

import java.util.Date;

@Entity
@Immutable
@Getter
@Table(name= "current_dept_emp")
public class CurrentDepartmentEmployee {
    @EmbeddedId
    private DepartmentPK departmentPK;
    private Date fromDate;
    private Date toDate;
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name="empNo", insertable=false, updatable=false)
    private Employee employee;
}

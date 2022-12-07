package com.openwt.employee.app.persistence.employee;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.openwt.employee.app.persistence.departement.CurrentDepartmentEmployee;
import com.openwt.employee.app.persistence.salary.Salary;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name= "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long empNo;
    private Date birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private Date hireDate;
    @JsonManagedReference
    @OneToMany(mappedBy = "employee")
    private List<Salary> salaries;
    @OneToMany(mappedBy = "employee")
    private List<CurrentDepartmentEmployee> currentDepartmentEmployee;
}
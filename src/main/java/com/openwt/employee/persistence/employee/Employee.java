package com.openwt.employee.persistence.employee;

import com.openwt.employee.persistence.departement.CurrentDepartmentEmployee;
import com.openwt.employee.persistence.departement.DepartmentEmployee;
import com.openwt.employee.persistence.salary.Salary;
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
    @OneToMany(mappedBy = "employee")
    private List<Salary> salaries;
    @OneToMany(mappedBy = "employee")
    private List<CurrentDepartmentEmployee> currentDepartments;
}
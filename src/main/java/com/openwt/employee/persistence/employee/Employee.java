package com.openwt.employee.persistence.employee;

import com.openwt.employee.persistence.departement.CurrentDepartmentEmployee;
import com.openwt.employee.persistence.salary.Salary;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name= "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long empNo;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate hireDate;
    @OneToMany(mappedBy = "employee")
    private List<Salary> salaries;
    @OneToMany(mappedBy = "employee")
    private List<CurrentDepartmentEmployee> currentDepartments;
    @Formula("(SELECT AVG(salaries.salary) FROM salaries INNER JOIN dept_emp ON salaries.emp_no = dept_emp.emp_no WHERE salaries.emp_no = emp_no)")
    private Double averageSalary;
}
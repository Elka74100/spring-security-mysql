package com.openwt.employee.app.persistence.employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long> {
    Employee findByEmpNo(Long empNo);
    @Query(
            value = "SELECT AVG(salaries.salary) FROM salaries INNER JOIN dept_emp ON salaries.emp_no = dept_emp.emp_no WHERE dept_no = :#{#deptNo}",
            nativeQuery = true
    )
    Double findAverageSalaryPerDepartment(@Param("deptNo") String deptNo);
}
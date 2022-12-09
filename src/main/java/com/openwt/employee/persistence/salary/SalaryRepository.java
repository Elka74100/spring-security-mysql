package com.openwt.employee.persistence.salary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SalaryRepository extends JpaRepository<Salary, Long> {
    @Query("""
            SELECT AVG(s.salary) FROM Salary s
            INNER JOIN DepartmentEmployee de ON s.salaryPK.empNo = de.departmentPK.empNo
            WHERE de.departmentPK.deptNo = ?1
            """)
    Double findAverageSalaryPerDepartment(String deptNo);
}

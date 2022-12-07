package com.openwt.employee.app.web.employee;

import com.openwt.employee.app.persistence.departement.CurrentDepartmentEmployee;
import com.openwt.employee.app.persistence.employee.Employee;
import com.openwt.employee.app.persistence.salary.Salary;
import com.openwt.employee.app.web.employee.dto.CurrentDepartmentEmployeeDto;
import com.openwt.employee.app.web.employee.dto.EmployeeDetailedDto;
import com.openwt.employee.app.web.employee.dto.EmployeeDto;
import com.openwt.employee.app.web.employee.dto.SalaryDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDto> toDto(List<Employee> employee);
    EmployeeDetailedDto toDto(Employee employee);
    @Mapping(target="fromDate", source="salaryPK.fromDate")
    SalaryDto toDto(Salary salary);
    @Mapping(target="deptNo", source="departmentPK.deptNo")
    CurrentDepartmentEmployeeDto toDto(CurrentDepartmentEmployee currentDepartmentEmployee);
}

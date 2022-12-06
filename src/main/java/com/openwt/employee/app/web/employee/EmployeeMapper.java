package com.openwt.employee.app.web.employee;

import com.openwt.employee.app.persistence.employee.Employee;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDto> toDto(List<Employee> employee);
}

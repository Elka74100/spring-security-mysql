package com.openwt.employee.app.web.employee;

import com.openwt.employee.app.persistence.employee.Employee;
import com.openwt.employee.app.web.employee.dto.EmployeeDetailedDto;
import com.openwt.employee.app.web.employee.dto.EmployeeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    List<EmployeeDto> toDto(List<Employee> employee);
    EmployeeDetailedDto toDto(Employee employee);
}

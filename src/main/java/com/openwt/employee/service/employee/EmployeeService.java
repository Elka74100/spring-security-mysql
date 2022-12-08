package com.openwt.employee.service.employee;

import com.openwt.employee.persistence.employee.Employee;
import com.openwt.employee.persistence.employee.EmployeeRepository;
import com.openwt.employee.web.employee.dto.EmployeeDetailedDto;
import com.openwt.employee.web.employee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeRepository employeeRepository;
    private static final EmployeeMapper mapper = new EmployeeMapperImpl();

    public List<EmployeeDto> getEmployees(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));
        Page<Employee> pagedResult = employeeRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return mapper.toDto(pagedResult.getContent());
        } else {
            return new ArrayList<>();
        }
    }

    public EmployeeDetailedDto getEmployee(Long empNo) {
        return mapper.toDto(employeeRepository.findByEmpNo(empNo));
    }

    public Double getAverageSalaryPerDepartment(String deptNo) {
        return employeeRepository.findAverageSalaryPerDepartment(deptNo);
    }
}
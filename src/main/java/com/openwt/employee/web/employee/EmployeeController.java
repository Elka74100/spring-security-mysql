package com.openwt.employee.web.employee;

import com.openwt.employee.service.employee.EmployeeService;
import com.openwt.employee.web.employee.dto.EmployeeDetailedDto;
import com.openwt.employee.web.employee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping()
    public List<EmployeeDto> getEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                          @RequestParam(defaultValue = "empNo") String sortBy) {
        return employeeService.getEmployees(pageNo, pageSize, sortBy);
    }

    @GetMapping("/{empNo}")
    public EmployeeDetailedDto getEmployee(@PathVariable final Long empNo) {
        return employeeService.getEmployee(empNo);
    }
}
package com.openwt.employee.app.web.employee;

import com.openwt.employee.app.service.employee.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    private static final EmployeeMapper mapper = new EmployeeMapperImpl();

    @GetMapping()
    public List<EmployeeDto> getEmployees(@RequestParam(defaultValue = "0") Integer pageNo,
                                       @RequestParam(defaultValue = "10") Integer pageSize,
                                       @RequestParam(defaultValue = "empNo") String sortBy) {
        return mapper.toDto(employeeService.getEmployees(pageNo, pageSize, sortBy));
    }
}
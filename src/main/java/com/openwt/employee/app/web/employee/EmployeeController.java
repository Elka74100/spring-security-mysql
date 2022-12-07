package com.openwt.employee.app.web.employee;

import com.openwt.employee.app.service.employee.EmployeeService;
import com.openwt.employee.app.web.employee.dto.EmployeeDetailedDto;
import com.openwt.employee.app.web.employee.dto.EmployeeDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{empNo}")
    public EmployeeDetailedDto getEmployee(@PathVariable final Long empNo) {
        return mapper.toDto(employeeService.getEmployee(empNo));
    }

    @GetMapping("/department/{deptNo}/average-salary")
    public Double getAverageSalaryPerDepartment(@PathVariable final String deptNo) {
         return employeeService.getAverageSalaryPerDepartment(deptNo);
    }
}
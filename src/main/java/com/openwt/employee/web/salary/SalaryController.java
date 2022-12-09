package com.openwt.employee.web.salary;

import com.openwt.employee.service.salary.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
@RequiredArgsConstructor
public class SalaryController {

    private final SalaryService salaryService;

    @GetMapping("/average-salary/department/{deptNo}")
    public Double getAverageSalaryPerDepartment(@PathVariable final String deptNo) {
        return salaryService.getAverageSalaryPerDepartment(deptNo);
    }
}

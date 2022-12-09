package com.openwt.employee.service.salary;

import com.openwt.employee.persistence.salary.SalaryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SalaryService {
    private final SalaryRepository salaryRepository;

    public Double getAverageSalaryPerDepartment(String deptNo) {
        return salaryRepository.findAverageSalaryPerDepartment(deptNo);
    }
}

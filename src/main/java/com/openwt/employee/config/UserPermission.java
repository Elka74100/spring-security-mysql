package com.openwt.employee.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum UserPermission {
    ALL_EMPLOYEES_READ("allEmployees:read"),
    EMPLOYEE_READ("employee:read");

    private final String permission;
}

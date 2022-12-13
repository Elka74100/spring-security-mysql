package com.openwt.employee.web.user.dto;

import lombok.Getter;

@Getter
public class AuthenticationRequestDto {
    private String email;
    private String password;
}

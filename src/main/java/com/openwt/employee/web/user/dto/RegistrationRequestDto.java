package com.openwt.employee.web.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationRequestDto {
    private String email;
    private String password;
    private boolean active;
    private String roles;
}

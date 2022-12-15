package com.openwt.employee.web.user.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
public class RegistrationRequestDto {
    private String email;
    private String password;
    private boolean active;
    private String roles;
}

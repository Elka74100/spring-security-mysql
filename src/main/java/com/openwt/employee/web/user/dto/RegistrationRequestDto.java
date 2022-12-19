package com.openwt.employee.web.user.dto;

import com.openwt.employee.config.UserRole;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class RegistrationRequestDto {
    private String email;
    private String password;
    private boolean active;
    private Set<UserRole> roles;
}

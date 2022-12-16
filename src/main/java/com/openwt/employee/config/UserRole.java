package com.openwt.employee.config;

import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.openwt.employee.config.UserPermission.*;


@RequiredArgsConstructor
@Getter
public enum UserRole {
    ADMIN(Sets.newHashSet(ALL_EMPLOYEES_READ, EMPLOYEE_READ)),
    USER(Sets.newHashSet(EMPLOYEE_READ));

    private final Set<UserPermission> permissions;

    public Set<SimpleGrantedAuthority> getGrantedAuthorities() {
        Set<SimpleGrantedAuthority> authorities = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        authorities.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return authorities;
    }
}

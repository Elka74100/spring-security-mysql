package com.openwt.employee.persistence.user;

import com.openwt.employee.config.UserRole;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;
import java.util.stream.Collectors;

@Entity
@Table(name = "Users")
@Getter
@Setter
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    private String password;
    private boolean active;
    private String roles;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        final Set<UserRole> userRoles = new HashSet<>();
        final String[] rolesString = roles.split(",");
        for(String authString : rolesString) {
            userRoles.add(UserRole.valueOf(authString));
        }

        return userRoles.stream().flatMap(role -> role.getGrantedAuthorities().stream()).collect(Collectors.toSet());
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }
}

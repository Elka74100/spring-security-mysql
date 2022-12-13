package com.openwt.employee.service.user;

import com.openwt.employee.config.JwtUtils;
import com.openwt.employee.persistence.user.User;
import com.openwt.employee.persistence.user.UserRepository;
import com.openwt.employee.web.user.dto.AuthenticationRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class UserService  {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    public String register(User user) {
        return jwtUtils.generateToken(save(user));
    }

    public String authenticate(AuthenticationRequestDto request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails user = userRepository.findByEmail(request.getEmail());
        if (user != null) {
            return jwtUtils.generateToken(user);
        } else {
            return null;
        }
    }

    private User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));

        return userRepository.save(user);
    }
}

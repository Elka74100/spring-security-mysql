package com.openwt.employee.web.user;

import com.openwt.employee.persistence.user.User;
import com.openwt.employee.service.user.UserService;
import com.openwt.employee.web.user.dto.AuthenticationRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/auth")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/register")
    public String register(@RequestBody final User user) {
        return userService.register(user);
    }

    @PostMapping("/authenticate")
    public String authenticate(@RequestBody AuthenticationRequestDto request) {
        return userService.authenticate(request);
    }
}

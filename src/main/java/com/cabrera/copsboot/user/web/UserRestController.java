package com.cabrera.copsboot.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Map;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    @GetMapping("/me")
    public Map<String, Object> myself(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
            "subject", jwt.getSubject(),
            "claims", jwt.getClaims()
        );
    }
}

@PostMapping
@ResponseStatus(HttpStatus.CREATED)
@PreAuthorize("hasRole('OFFICER')")
public UserDto createUser(@AuthenticationPrincipal Jwt jwt,
                          @RequestBody CreateUserRequest request) {
    CreateUserParameters parameters = request.toParameters(jwt);
    User user = userService.createUser(parameters);
    return UserDto.fromUser(user);
}
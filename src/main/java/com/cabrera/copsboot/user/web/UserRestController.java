package com.cabrera.copsboot.user.web;

import com.cabrera.copsboot.aplicaction.service.UserService;
import com.cabrera.copsboot.user.domain.CreateUserParameters;
import com.cabrera.copsboot.user.domain.User;
import com.cabrera.copsboot.user.web.CreateUserRequest;
import com.cabrera.copsboot.user.web.UserDto;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
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
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserRestController {

    private final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/me")
    public Map<String, Object> myself(@AuthenticationPrincipal Jwt jwt) {
        return Map.of(
                "subject", jwt.getSubject(),
                "claims", jwt.getClaims()
        );
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @PreAuthorize("hasRole('OFFICER')")
    public UserDto createUser(@AuthenticationPrincipal Jwt jwt,
                              @Valid @RequestBody CreateUserRequest request) {
        CreateUserParameters parameters = request.toParameters(jwt);

        Optional<User> existingUser = userService.findUserByAuthServerId(parameters.authServerId());

        if (existingUser.isPresent()) {
            System.out.println("🔁 Usuario ya existe, devolviendo DTO.");
            return UserDto.fromUser(existingUser.get());
        }

        User user = userService.createUser(parameters);
        System.out.println("✅ Usuario nuevo creado: " + user.getEmail());
        return UserDto.fromUser(user);
    }
}
package com.cabrera.copsboot.user.web;

import com.cabrera.copsboot.user.domain.AuthServerId;
import com.cabrera.copsboot.user.domain.CreateUserParameters;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.UUID;

public record CreateUserRequest(
        @NotEmpty String mobileToken
) {
    public CreateUserParameters toParameters(Jwt jwt) {
        AuthServerId authServerId = new AuthServerId(UUID.fromString(jwt.getSubject()));
        String email = jwt.getClaimAsString("email");
        return new CreateUserParameters(authServerId, email, mobileToken);
    }
}
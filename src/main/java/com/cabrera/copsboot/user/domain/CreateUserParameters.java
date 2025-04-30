package com.cabrera.copsboot.user.domain;


public record CreateUserParameters(AuthServerId authServerId, String email, String mobileToken) {}

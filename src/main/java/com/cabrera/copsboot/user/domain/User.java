package com.cabrera.copsboot.user.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;


import jakarta.persistence.*;

@Entity
@Table(name = "copsboot_user")
public class User {

    @EmbeddedId
    private UserId id;

    private String email;

    @Embedded
    private AuthServerId authServerId;

    private String mobileToken;

    protected User() {
    }

    public User(UserId id, String email, AuthServerId authServerId, String mobileToken) {
        this.id = id;
        this.email = email;
        this.authServerId = authServerId;
        this.mobileToken = mobileToken;
    }

    public UserId getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public AuthServerId getAuthServerId() {
        return authServerId;
    }

    public String getMobileToken() {
        return mobileToken;
    }
}
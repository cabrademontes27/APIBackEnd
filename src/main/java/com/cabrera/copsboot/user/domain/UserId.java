package com.cabrera.copsboot.domain;

import java.util.UUID;

import jakarta.persistence.Embeddable;

@Embeddable
public class UserId {

    private UUID id;

    protected UserId() {

    }

    public UserId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public String asString() {
        return id.toString();
    }

}
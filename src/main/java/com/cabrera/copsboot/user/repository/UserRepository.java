package com.cabrera.copsboot.user.repository;

import com.cabrera.copsboot.user.domain.AuthServerId;
import com.cabrera.copsboot.user.domain.User;
import com.cabrera.copsboot.user.domain.UserId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, UserId> {
    Optional<User> findByEmail(String email);
    Optional<User> findByAuthServerId(AuthServerId authServerId);
    default UserId nextId() {
        return new UserId(java.util.UUID.randomUUID());
    }
}
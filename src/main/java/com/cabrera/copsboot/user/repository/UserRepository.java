package com.cabrera.copsboot.repository;

import com.cabrera.copsboot.domain.User;
import com.cabrera.copsboot.domain.UserId;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, UserId> {
    Optional<User> findByEmail(String email);
}
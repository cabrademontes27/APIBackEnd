package com.cabrera.copsboot.aplicaction.service;


import com.cabrera.copsboot.user.domain.*;
import com.cabrera.copsboot.user.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> findUserByAuthServerId(AuthServerId authServerId) {
        return userRepository.findByAuthServerId(authServerId);
    }

    public User createUser(CreateUserParameters parameters) {
        UserId userId = userRepository.nextId();
        User user = new User(userId, parameters.email(), parameters.authServerId(), parameters.mobileToken());
        return userRepository.save(user);
    }
}

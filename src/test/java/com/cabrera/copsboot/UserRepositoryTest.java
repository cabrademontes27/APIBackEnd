package com.cabrera.copsboot;

import com.cabrera.copsboot.user.domain.User;
import com.cabrera.copsboot.user.domain.UserId;
import com.cabrera.copsboot.user.domain.UserRole;
import com.cabrera.copsboot.user.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void testStoreUser() {
       
    }
}
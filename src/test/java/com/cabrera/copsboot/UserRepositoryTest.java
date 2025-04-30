package com.cabrera.copsboot;

import com.cabrera.copsboot.domain.*;
import com.cabrera.copsboot.repository.UserRepository;
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
        Set<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);

        UserId userId = new UserId(UUID.randomUUID());

        User user = new User(userId, "alex.foley@beverly-hills.com", "my-secret-pwd", roles);

        User savedUser = repository.save(user);

        assertThat(savedUser).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
    }
}
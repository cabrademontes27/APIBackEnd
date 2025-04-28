package com.cabrera.copsboot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.cabrera.copsboot.domain.User;
import com.cabrera.copsboot.domain.User.UserRole;
import com.cabrera.copsboot.domain.UserRepository;

import java.util.HashSet;
import java.util.UUID;
import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
class UserRepositoryTest {

    @Autowired
    private UserRepository repository;

    @Test
    void testStoreUser() {
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.OFFICER);
        
        User user = new User(UUID.randomUUID(), "alex.foley@beverly-hills.com", "my-secret-pwd", roles);
        
        User savedUser = repository.save(user);
        
        assertThat(savedUser).isNotNull();
        assertThat(repository.count()).isEqualTo(1L);
    }
}
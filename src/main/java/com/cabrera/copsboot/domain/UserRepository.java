package com.cabrera.copsboot.domain;

import org.springframework.data.repository.CrudRepository;
import java.util.UUID;

public interface UserRepository extends CrudRepository<User, UUID> {
    
}

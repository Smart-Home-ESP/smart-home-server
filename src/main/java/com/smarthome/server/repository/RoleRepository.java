package com.smarthome.server.repository;

import java.util.Optional;

import com.smarthome.server.entity.Role;
import com.smarthome.server.entity.enums.ERole;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}

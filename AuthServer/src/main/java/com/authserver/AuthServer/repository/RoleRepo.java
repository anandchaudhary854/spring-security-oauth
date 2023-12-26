package com.authserver.AuthServer.repository;

import com.authserver.AuthServer.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepo extends JpaRepository<Role, Integer> {
    Optional<Role> findByAuthority(String authority);
}

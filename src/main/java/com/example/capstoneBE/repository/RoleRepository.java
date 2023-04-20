package com.example.capstoneBE.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.capstoneBE.entity.ERole;
import com.example.capstoneBE.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}

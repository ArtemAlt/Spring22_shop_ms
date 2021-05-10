package ru.education.customerms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.customerms.models.entity.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String role);
    Optional<Role> findById(Long id);
}

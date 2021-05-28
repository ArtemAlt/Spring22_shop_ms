package ru.education.customerms.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.education.customerms.models.entity.ShopRole;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<ShopRole, Long> {
    ShopRole findByName(String role);
    Optional<ShopRole> findById(Long id);
}

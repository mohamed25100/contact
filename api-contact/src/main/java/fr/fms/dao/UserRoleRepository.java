package fr.fms.dao;

import fr.fms.entities.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    // You can add custom queries here if needed
}

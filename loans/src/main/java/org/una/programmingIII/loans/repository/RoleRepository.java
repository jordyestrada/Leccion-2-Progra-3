package org.una.programmingIII.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.programmingIII.loans.model.Role;
import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
  Optional<Role> findByName(String name);
}

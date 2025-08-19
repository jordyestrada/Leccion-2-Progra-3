package org.una.programmingIII.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.programmingIII.loans.model.User;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findByEmail(String email);
}

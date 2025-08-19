package org.una.programmingIII.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.programmingIII.loans.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> { }

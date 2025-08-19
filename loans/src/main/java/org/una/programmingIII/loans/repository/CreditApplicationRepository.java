package org.una.programmingIII.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.programmingIII.loans.model.CreditApplication;

public interface CreditApplicationRepository extends JpaRepository<CreditApplication, Long> { }

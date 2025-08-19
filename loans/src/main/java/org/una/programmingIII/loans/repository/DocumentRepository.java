package org.una.programmingIII.loans.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.una.programmingIII.loans.model.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> { }

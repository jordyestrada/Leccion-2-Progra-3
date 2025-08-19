package org.una.programmingIII.loans.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity @Table(name="documents")
public class Document {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @Enumerated(EnumType.STRING) @Column(nullable=false, length=30)
  private DocumentType type;

  @Column(nullable=false) private String fileName;
  @Column(nullable=false) private String storagePath;
  @Column(nullable=false) private LocalDateTime uploadedAt;

  @ManyToOne(optional=false)
  @JoinColumn(name="credit_application_id", nullable=false,
    foreignKey=@ForeignKey(name="fk_document_credit_application"))
  private CreditApplication creditApplication;

  @PrePersist public void onUpload(){ uploadedAt = LocalDateTime.now(); }
}

package org.una.programmingIII.loans.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity @Table(name="credit_applications")
public class CreditApplication {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;

  @ManyToOne(optional=false)
  @JoinColumn(name="user_id", nullable=false,
    foreignKey=@ForeignKey(name="fk_credit_application_user"))
  private User applicant;

  @Column(nullable=false, precision=14, scale=2) private BigDecimal amount;
  @Column(nullable=false) private Integer termMonths;

  @Enumerated(EnumType.STRING) @Column(nullable=false, length=20)
  private CreditApplicationStatus status = CreditApplicationStatus.SUBMITTED;

  @Column(nullable=false) private LocalDateTime createdAt;
  @Column(nullable=false) private LocalDateTime updatedAt;

  @OneToMany(mappedBy="creditApplication", cascade=CascadeType.ALL, orphanRemoval=true)
  private List<Document> documents = new ArrayList<>();

  @PrePersist public void onCreate(){ createdAt=LocalDateTime.now(); updatedAt=createdAt; }
  @PreUpdate  public void onUpdate(){ updatedAt=LocalDateTime.now(); }
}

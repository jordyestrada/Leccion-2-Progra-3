package org.una.programmingIII.loans.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "users",
       uniqueConstraints = {
         @UniqueConstraint(name = "uk_users_email", columnNames = "email"),
         @UniqueConstraint(name = "uk_users_identification", columnNames = "identification_number")
       })
public class User {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  @Column(nullable = false) private String name;
  @Column(nullable = false, unique = true, length = 120) private String email;
  @Column(nullable = false) private String password;
  @Column(name="identification_number", nullable = false, unique = true, length = 50)
  private String identificationNumber;
  @Enumerated(EnumType.STRING) @Column(nullable = false, length = 20)
  private UserState state = UserState.ACTIVE;
  @Column(nullable = false) private LocalDateTime createdAt;
  @Column(nullable = false) private LocalDateTime updatedAt;
  @PrePersist public void onCreate(){ createdAt=LocalDateTime.now(); updatedAt=createdAt; }
  @PreUpdate  public void onUpdate(){ updatedAt=LocalDateTime.now(); }
}

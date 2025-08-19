package org.una.programmingIII.loans.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="roles", uniqueConstraints=@UniqueConstraint(name="uk_roles_name", columnNames="name"))
public class Role {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  @Column(nullable=false, unique=true, length=50) private String name;
  private String description;
}

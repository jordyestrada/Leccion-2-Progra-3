package org.una.programmingIII.loans.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity @Table(name="clients")
public class Client {
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
  @Column(nullable=false) private String firstName;
  @Column(nullable=false) private String lastName;
  @Column(nullable=false, unique=true, length=120) private String email;
  private String phone;
  private String address;
}

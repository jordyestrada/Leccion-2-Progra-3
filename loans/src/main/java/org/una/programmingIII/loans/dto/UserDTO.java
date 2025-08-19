package org.una.programmingIII.loans.dto;

import lombok.Data;
import org.una.programmingIII.loans.model.UserState;

@Data
public class UserDTO {
  private Long id;
  private String name;
  private String email;
  private String password;
  private String identificationNumber;
  private UserState state;
}

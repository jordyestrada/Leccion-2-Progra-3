package org.una.programmingIII.loans.service;

import org.una.programmingIII.loans.dto.UserDTO;
import java.util.List;
import java.util.Optional;

public interface UserService {
  List<UserDTO> findAll();
  Optional<UserDTO> findById(Long id);
  Optional<UserDTO> findByEmail(String email);
  UserDTO create(UserDTO dto);
  Optional<UserDTO> update(Long id, UserDTO dto);
  void delete(Long id);
}

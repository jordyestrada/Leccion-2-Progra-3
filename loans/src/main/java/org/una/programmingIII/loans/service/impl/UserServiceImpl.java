package org.una.programmingIII.loans.service.impl;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.una.programmingIII.loans.dto.UserDTO;
import org.una.programmingIII.loans.model.User;
import org.una.programmingIII.loans.repository.UserRepository;
import org.una.programmingIII.loans.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final ModelMapper modelMapper;

  @Override
  public List<UserDTO> findAll() {
    return userRepository.findAll().stream()
      .map(u -> modelMapper.map(u, UserDTO.class))
      .collect(Collectors.toList());
  }

  @Override
  public Optional<UserDTO> findById(Long id) {
    return userRepository.findById(id).map(u -> modelMapper.map(u, UserDTO.class));
  }

  @Override
  public Optional<UserDTO> findByEmail(String email) {
    return userRepository.findByEmail(email).map(u -> modelMapper.map(u, UserDTO.class));
  }

  @Override
  public UserDTO create(UserDTO dto) {
    User u = modelMapper.map(dto, User.class);
    u = userRepository.save(u);
    return modelMapper.map(u, UserDTO.class);
  }

  @Override
  public Optional<UserDTO> update(Long id, UserDTO dto) {
    return userRepository.findById(id).map(existing -> {
      existing.setName(dto.getName());
      existing.setEmail(dto.getEmail());
      existing.setPassword(dto.getPassword());
      existing.setIdentificationNumber(dto.getIdentificationNumber());
      existing.setState(dto.getState());
      User saved = userRepository.save(existing);
      return modelMapper.map(saved, UserDTO.class);
    });
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}

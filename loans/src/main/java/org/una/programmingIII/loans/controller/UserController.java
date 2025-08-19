package org.una.programmingIII.loans.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.programmingIII.loans.dto.UserDTO;
import org.una.programmingIII.loans.service.UserService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  @GetMapping
  public List<UserDTO> findAll() { return userService.findAll(); }

  @GetMapping("/{id}")
  public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
    Optional<UserDTO> dto = userService.findById(id);
    return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @GetMapping("/findByEmail")
  public ResponseEntity<UserDTO> findByEmail(@RequestParam String email) {
    Optional<UserDTO> dto = userService.findByEmail(email);
    return dto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<UserDTO> create(@RequestBody UserDTO dto) {
    UserDTO created = userService.create(dto);
    return ResponseEntity.created(URI.create("/api/users/" + created.getId())).body(created);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody UserDTO dto) {
    return userService.update(id, dto)
      .map(ResponseEntity::ok)
      .orElseGet(() -> ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    userService.delete(id);
    return ResponseEntity.noContent().build();
  }
}

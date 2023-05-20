package API_ProyectoFinanzas.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import API_ProyectoFinanzas.user.dtos.UpdateUserDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
  private final UserService userService;

  @GetMapping
  public ResponseEntity<List<User>> getUsers() {
    return ResponseEntity.ok(userService.getAllUsers());
  }

  @GetMapping("/{id}")
  public User getUserById(@PathVariable Long id) {
    return userService.getUserById(id);
  }

  @PutMapping("/{id}")
  public User updateUser(@PathVariable Long id, @RequestBody UpdateUserDTO updateUserDTO) {
    return userService.updateUser(id, updateUserDTO);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> darDeBajaUsuario(@PathVariable("id") Long id) {
    User user = userService.findById(id);
    if (user != null) {
      userService.unsubscribeUser(id);
      return ResponseEntity.ok("Usuario dado de baja exitosamente");
    } else {
      return ResponseEntity.notFound().build();
    }
  }
}

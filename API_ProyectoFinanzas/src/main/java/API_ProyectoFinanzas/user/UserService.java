package API_ProyectoFinanzas.user;

import java.util.List;

import org.springframework.stereotype.Service;

import API_ProyectoFinanzas.user.dtos.UpdateUserDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
  private final UserRepository userRepository;

  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  public User getUserById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public User updateUser(Long id, UpdateUserDTO updateUserDTO) {
    User user = userRepository.findById(id).orElse(null);
    if (user != null) {
      if (updateUserDTO.getLastname() != null) {
        user.setLastname(updateUserDTO.getLastname());
      }
      if (updateUserDTO.getFirstname() != null) {
        user.setFirstname(updateUserDTO.getFirstname());
      }
      if (updateUserDTO.getEmail() != null) {
        user.setEmail(updateUserDTO.getEmail());
      }
      if (updateUserDTO.getPassword() != null) {
        user.setPassword(updateUserDTO.getPassword());
      }
      return userRepository.save(user);
    }
    return null;
  }

  public User findById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  public void unsubscribeUser(Long id) {
    User user = userRepository.findById(id).orElse(null);
    if (user != null) {
      // Realizar las acciones necesarias para dar de baja al usuario
      userRepository.delete(user);
    }
  }
}

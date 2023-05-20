package API_ProyectoFinanzas.auth;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import API_ProyectoFinanzas.config.JwtService;
import API_ProyectoFinanzas.enums.Role;
import API_ProyectoFinanzas.user.User;
import API_ProyectoFinanzas.user.UserRepository;
import lombok.RequiredArgsConstructor;

// ORM llamado Hibernate
// ORM son funciones que realizan consultas a la base de datos sin realizar una consulta directa
@Service // Un servicio es la representación del modelo de negocio de la aplicación
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstname(request.getFirstname())
                .lastname(request.getLastname())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        repository.save(user); // saved user
        var jwtToken = jwtService.generateToken(user); // generated token
        return AuthResponse.builder()
                .user(user)
                .token(jwtToken)
                .build();
    }

    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
        var user = repository.findByEmail(request.getEmail()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder()
                .user(user)
                .token(jwtToken)
                .build();
    }
}
package HackathonRecu.Auth.Domain;

import HackathonRecu.Auth.DTOS.JwtAuthResponse;
import HackathonRecu.Auth.DTOS.LoginReq;
import HackathonRecu.Auth.DTOS.RegisterReq;
import HackathonRecu.Auth.Exceptions.UserAlreadyExistsException;
import HackathonRecu.Config.JwtService;
import HackathonRecu.User.Domain.User;
import HackathonRecu.User.Infrastructure.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final ModelMapper modelMapper;

    @Autowired
    public AuthService(UserRepository userRepository, JwtService jwtService, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jwtService = jwtService;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = new ModelMapper();
    }

    public JwtAuthResponse login(LoginReq req) {
        Optional<User> user;
        user = userRepository.findByEmail(req.getEmail());

        if (user.isEmpty()) throw new UsernameNotFoundException("Email is not registered");

        if (!passwordEncoder.matches(req.getPassword(), user.get().getPassword()))
            throw new IllegalArgumentException("Password is incorrect");

        JwtAuthResponse response = new JwtAuthResponse();

        response.setToken(jwtService.generateToken(user.get()));
        return response;
    }

    public JwtAuthResponse register(RegisterReq req){
        Optional<User> user = userRepository.findByEmail(req.getEmail());
        //if (user.isPresent()) throw new UserAlreadyExistsException("Email is already registered");
        if (user.isPresent()) throw new UserAlreadyExistsException("Email is already registered");

        User usuario_nuevo=new User();
        usuario_nuevo.setEmail(req.getEmail());
        usuario_nuevo.setPassword(passwordEncoder.encode(req.getPassword()));
        usuario_nuevo.setNombre(req.getNombre());
        usuario_nuevo.setFechaDeRegistro(req.getFechaDeRegistro());
        userRepository.save(usuario_nuevo);
        JwtAuthResponse response=new JwtAuthResponse();
        response.setToken(jwtService.generateToken(usuario_nuevo));
        return response;

    }

}

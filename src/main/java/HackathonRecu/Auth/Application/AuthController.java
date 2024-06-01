package HackathonRecu.Auth.Application;

import HackathonRecu.Auth.DTOS.JwtAuthResponse;
import HackathonRecu.Auth.DTOS.LoginReq;
import HackathonRecu.Auth.DTOS.RegisterReq;
import HackathonRecu.Auth.Domain.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class AuthController {
    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginReq req) {
        return ResponseEntity.ok(authService.login(req));
    }

    @PostMapping("/register")
    public ResponseEntity<JwtAuthResponse> register(@RequestBody RegisterReq req) {
        return ResponseEntity.ok(authService.register(req));
    }
}

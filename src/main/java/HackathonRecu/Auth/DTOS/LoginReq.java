package HackathonRecu.Auth.DTOS;

import lombok.Data;

@Data
public class LoginReq {
    private String email;
    private String password;
}

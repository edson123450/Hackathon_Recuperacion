package HackathonRecu.Auth.DTOS;

import lombok.Data;

import java.util.Date;

@Data
public class RegisterReq {

    private String nombre;
    private String email;
    private String password;
    private Date fechaDeRegistro;
}

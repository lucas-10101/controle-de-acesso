package tms.backend.controledeacesso.data.models;

import lombok.Data;

@Data
public class TokenRequest {

    private String username;

    private String password;

    private String refreshToken;
}

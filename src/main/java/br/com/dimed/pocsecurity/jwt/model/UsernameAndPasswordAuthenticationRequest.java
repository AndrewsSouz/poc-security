package br.com.dimed.pocsecurity.jwt.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

@Getter
@Setter
public class UsernameAndPasswordAuthenticationRequest {
    private String username;
    private String password;

    public Authentication getAuthToken() {
        return new UsernamePasswordAuthenticationToken(
                getUsername(),
                getPassword()
        );
    }
}

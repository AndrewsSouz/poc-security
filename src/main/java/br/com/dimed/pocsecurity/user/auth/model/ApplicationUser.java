package br.com.dimed.pocsecurity.user.auth.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

@Getter
@Document("users")
@AllArgsConstructor
public class ApplicationUser implements UserDetails {
    @Id
    private final String id;
    private final String level;
    @Setter
    private Set<SimpleGrantedAuthority> authorities;
    private final String username;
    @Setter
    private String password;
    private final boolean isAccountNonExpired;
    private final boolean isAccountNonLocked;
    private final boolean isCredentialsNonExpired;
    private final boolean isEnabled;
}

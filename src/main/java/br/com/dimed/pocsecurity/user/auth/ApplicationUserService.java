package br.com.dimed.pocsecurity.user.auth;

import br.com.dimed.pocsecurity.user.auth.model.ApplicationUser;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

import static br.com.dimed.pocsecurity.security.ApplicationUserRole.*;

@Service
@AllArgsConstructor
public class ApplicationUserService implements UserDetailsService {

    private final ApplicationUserRepository applicationUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.applicationUserRepository
                .findApplicationUserByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException(String.format("Username %s not found", username)));
    }

    public List<ApplicationUser> findAll() {
        return applicationUserRepository.findAll();
    }

    public UserDetails createUser(ApplicationUser user) {
        switch (user.getLevel()) {
            case "admin":
                user.setAuthorities(ADMIN.getGrantedAuthorities());
                break;
            case "student":
                user.setAuthorities(STUDENT.getGrantedAuthorities());
                break;
            case "admintrainee":
                user.setAuthorities(ADMINTRAINEE.getGrantedAuthorities());
                break;
            default:
                System.err.println("Level must be student/admintrainee/admin");
        }
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        return applicationUserRepository.save(user);
    }
}

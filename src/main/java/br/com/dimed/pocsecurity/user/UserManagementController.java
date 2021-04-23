package br.com.dimed.pocsecurity.user;

import br.com.dimed.pocsecurity.user.auth.ApplicationUserService;
import br.com.dimed.pocsecurity.user.auth.model.ApplicationUser;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("management/api/v1/users")
@AllArgsConstructor
public class UserManagementController {

    private final ApplicationUserService applicationUserService;

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public List<ApplicationUser> getUsers() {
        return applicationUserService.findAll();
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public UserDetails createUser(@RequestBody ApplicationUser user) {
        return applicationUserService.createUser(user);
    }
}

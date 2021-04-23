package br.com.dimed.pocsecurity.user.auth;

import br.com.dimed.pocsecurity.user.auth.model.ApplicationUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends MongoRepository<ApplicationUser, String> {
    Optional<ApplicationUser> findApplicationUserByUsername(String username);
}

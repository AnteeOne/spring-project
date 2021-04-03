package tech.anteeone.beatsell.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.anteeone.beatsell.models.User;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

}

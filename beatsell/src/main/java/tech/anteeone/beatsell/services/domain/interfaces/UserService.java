package tech.anteeone.beatsell.services.domain.interfaces;

import tech.anteeone.beatsell.exceptions.UserNotFoundException;
import tech.anteeone.beatsell.models.User;

public interface UserService {

    User findByEmail(String email) throws UserNotFoundException;

}

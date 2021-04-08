package tech.anteeone.beatsell.services.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.anteeone.beatsell.utils.exceptions.UserNotFoundException;
import tech.anteeone.beatsell.models.User;
import tech.anteeone.beatsell.repositories.jpa.UsersRepository;
import tech.anteeone.beatsell.services.domain.interfaces.UserService;

import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UsersRepository usersRepository;

    @Override
    public User findByEmail(String email) throws UserNotFoundException {
        try {
            Optional<User> user = usersRepository.findByEmail(email);
            if(!user.isPresent()) throw new UserNotFoundException();
            else return user.get();
        }
        catch (Exception e){
            throw new UserNotFoundException(e);
        }

    }
}

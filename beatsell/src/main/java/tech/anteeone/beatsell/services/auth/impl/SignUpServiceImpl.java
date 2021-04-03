package tech.anteeone.beatsell.services.auth.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import tech.anteeone.beatsell.dto.UserSignUpDto;
import tech.anteeone.beatsell.models.User;
import tech.anteeone.beatsell.repositories.jpa.UsersRepository;
import tech.anteeone.beatsell.services.auth.interfaces.SignUpService;

@Component
public class SignUpServiceImpl implements SignUpService {

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    public boolean signUp(UserSignUpDto dto) {
        if (!usersRepository.findByEmail(dto.getEmail()).isPresent()){
            User user = User.builder()
                    .email(dto.getEmail())
                    .hashPassword(passwordEncoder.encode(dto.getPassword()))
                    .role(User.Role.USER)
                    .state(User.State.ACTIVE)
                    .build();
            usersRepository.save(user);
            return true;
        }
        return false;
    }
}

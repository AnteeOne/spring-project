package tech.anteeone.beatsell.services.auth.interfaces;

import tech.anteeone.beatsell.dto.UserSignUpDto;

public interface SignUpService {

    boolean signUp(UserSignUpDto userSignUpDto);

}

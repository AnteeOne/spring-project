package tech.anteeone.beatsell.services.validation.interfaces;

import org.springframework.validation.BindingResult;
import tech.anteeone.beatsell.dto.UserSignInDto;
import tech.anteeone.beatsell.dto.UserSignUpDto;

import java.util.Map;

public interface UserValidationService {

    boolean isValid(UserSignInDto dto, BindingResult bindingResult);

    boolean isValid(UserSignUpDto dto, BindingResult bindingResult);
}

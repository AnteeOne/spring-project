package tech.anteeone.beatsell.services.validation.impl;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import tech.anteeone.beatsell.dto.UserSignInDto;
import tech.anteeone.beatsell.dto.UserSignUpDto;
import tech.anteeone.beatsell.services.validation.interfaces.UserValidationService;

import java.util.Map;
import java.util.stream.Collectors;

public class UserValidationSericeImpl implements UserValidationService {

    @Override
    public boolean isValid(UserSignInDto dto , BindingResult bindingResult) {
        return false;
    }

    @Override
    public boolean isValid(UserSignUpDto dto , BindingResult bindingResult) {
        return false;
    }
}

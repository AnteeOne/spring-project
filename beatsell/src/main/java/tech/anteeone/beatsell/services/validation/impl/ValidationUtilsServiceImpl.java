package tech.anteeone.beatsell.services.validation.impl;

import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import tech.anteeone.beatsell.services.validation.interfaces.ValidationUtilsService;

import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ValidationUtilsServiceImpl implements ValidationUtilsService {
    @Override
    public Map<String, String> getErrors(BindingResult bindingResult) {
        Map<String,String> errors = bindingResult.getFieldErrors().stream().collect(Collectors.toMap(
                fieldError -> fieldError.getField() + "Error",
                FieldError::getDefaultMessage
        ));
        return errors;
    }
}

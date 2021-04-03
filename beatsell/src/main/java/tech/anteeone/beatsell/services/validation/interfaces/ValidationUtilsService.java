package tech.anteeone.beatsell.services.validation.interfaces;

import org.springframework.validation.BindingResult;

import java.util.Map;

public interface ValidationUtilsService {
    Map<String,String> getErrors(BindingResult bindingResult);
}

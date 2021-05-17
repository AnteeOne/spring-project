package tech.anteeone.beatsell.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.anteeone.beatsell.dto.UserSignUpDto;
import tech.anteeone.beatsell.services.auth.interfaces.SignUpService;
import tech.anteeone.beatsell.services.validation.interfaces.ValidationUtilsService;

import javax.validation.Valid;

@Controller
public class SignUpController {

    @Autowired
    SignUpService signUpService;

    @Autowired
    ValidationUtilsService validationUtils;

    @GetMapping("/signup")
    public String getSignUpPage(){
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@Valid UserSignUpDto dto, BindingResult bindingResult, Model model){
        if(dto.getPassword()!=null && !dto.getPassword().equals(dto.getPassword2())){
            System.out.println("____________________________________________________________________________ 2");
            model.addAttribute("passwordMatchError","Passwords are different");
            return "signup";
        }
        if(bindingResult.hasErrors()){
            System.out.println("____________________________________________________________________________ 1");
            model.mergeAttributes(validationUtils.getErrors(bindingResult));
            return "signup";
        }
        if (!signUpService.signUp(dto)){
            System.out.println("____________________________________________________________________________ 0");
            model.addAttribute("usernameError","User already exists!");
            return "signup";
        }
        return "redirect:/signin";
    }
}

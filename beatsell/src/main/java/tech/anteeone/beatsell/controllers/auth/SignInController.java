package tech.anteeone.beatsell.controllers.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.anteeone.beatsell.dto.UserSignInDto;

@Controller
public class SignInController {

    @GetMapping("/signin")
    private String getSignInPage(){
        return "signin";
    }

    @PostMapping("/signin")
    private void signIn(UserSignInDto dto){}

}

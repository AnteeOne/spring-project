package tech.anteeone.beatsell.controllers.domain;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.anteeone.beatsell.models.User;

import java.security.Principal;

@Controller
public class HomeController {

    @GetMapping("/home")
    private String getHomePage(Model model, Principal principal){
        model.addAttribute("user", principal);
        return "home";
    }

}

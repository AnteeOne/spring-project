package tech.anteeone.beatsell.controllers.domain;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    private String getHomePage(Model model){
        model.addAttribute("currentUser", SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return "home";
    }

}

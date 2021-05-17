package tech.anteeone.beatsell.controllers.domain;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;
import tech.anteeone.beatsell.utils.exceptions.UserNotFoundException;
import tech.anteeone.beatsell.models.User;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;
import tech.anteeone.beatsell.services.domain.interfaces.UserService;

import java.security.Principal;

@Controller
@Slf4j
public class HomeController {

    @Autowired
    UserService userService;

    @Autowired
    BeatsService beatsService;

    @Autowired
    Logger logger;


    @GetMapping("/home")
    String getHomePage(Model model, Principal principal){
        try {
            User user = userService.findByEmail(principal.getName());
            model.addAttribute("beatsCount",beatsService.getAllBeats().size());
            model.addAttribute("user", user);
            return "home";
        }
        catch (UserNotFoundException | BeatNotFoundException e){
            logger.error("error",e);
            return "error";
        }
    }

}

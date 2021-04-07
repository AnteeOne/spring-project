package tech.anteeone.beatsell.controllers.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.anteeone.beatsell.exceptions.BeatNotFoundException;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;

import java.security.Principal;

@Controller
public class BeatsController {

    @Autowired
    BeatsService beatsService;

    @GetMapping("/beats")
    private String getBeatsPage(Model model, Principal principal){
        try {
            model.addAttribute("beatsList",beatsService.getAllUserBookedBeats(principal.getName()));
            return "beats";
        } catch (BeatNotFoundException e) {
            e.printStackTrace();
            return "error";
        }
    }

}
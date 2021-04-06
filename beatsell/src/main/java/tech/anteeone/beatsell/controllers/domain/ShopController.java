package tech.anteeone.beatsell.controllers.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.anteeone.beatsell.exceptions.BeatNotFoundException;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;

@Controller
public class ShopController {

    @Autowired
    BeatsService beatsService;

    @GetMapping("/shop")
    private String getShopPage(Model model){
        try {
            model.addAttribute("beatsList",beatsService.getAllBeats());
            return "shop";
        } catch (BeatNotFoundException e) {
            e.printStackTrace();
            return "error";
        }
    }

}

package tech.anteeone.beatsell.controllers.domain;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.anteeone.beatsell.services.domain.interfaces.OffersService;
import tech.anteeone.beatsell.utils.exceptions.OfferNotFoundException;

import java.security.Principal;

@Controller
public class OffersController {

    @Autowired
    Logger logger;

    @Autowired
    OffersService offersService;

    @GetMapping(value = "/offers")
    public String getOffers(Model model , Principal principal){
        try {
            model.addAttribute("offersList" , offersService.getAllOffers());
            return "offers";
        } catch (OfferNotFoundException e) {
            logger.error("error" , e);
            return "error";
        }
    }

}

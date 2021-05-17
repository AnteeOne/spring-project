package tech.anteeone.beatsell.controllers.admin;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tech.anteeone.beatsell.dto.OfferDto;
import tech.anteeone.beatsell.services.domain.interfaces.OffersService;
import tech.anteeone.beatsell.utils.exceptions.OfferNotFoundException;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AdminOffersController {

    @Autowired
    Logger logger;

    @Autowired
    OffersService offersService;

    @GetMapping(value = "/admin/offers")
    public String getOffers(Model model , Principal principal){
        try {
            model.addAttribute("offersList" , offersService.getAllOffers());
            return "admin_offers";
        } catch (OfferNotFoundException e) {
            logger.error("error" , e);
            return "error";
        }
    }


    @PostMapping(value = "/admin/offers",params = {"saveoffer"})
    public String saveOffer(@Valid OfferDto offerDto,
                           BindingResult bindingResult,
                           Model model){
        try {
            if(bindingResult.hasErrors()){
                AdminControllerUtils.loadFormResult(model,false,"description");
                model.addAttribute("offersList" , offersService.getAllOffers());
                return "admin_offers";
            }
            offersService.addOffer(offerDto);
            return "redirect:/admin/offers";
        }
        catch (Exception e){
            logger.error("error",e);
            return "redirect:error";
        }
    }

    @PostMapping(value = "/admin/offers/{id}",params = {"deleteoffer"})
    public String deleteOffer(@PathVariable("id") String id){
        try {
            offersService.deleteOfferById(id);
            return "redirect:/admin/offers";
        }
        catch (Exception e){
            logger.error("error",e);
            return "redirect:error";
        }
    }

}

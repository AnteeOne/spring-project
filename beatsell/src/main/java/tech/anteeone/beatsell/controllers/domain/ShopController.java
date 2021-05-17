package tech.anteeone.beatsell.controllers.domain;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;

@Controller
public class ShopController {

    @Autowired
    BeatsService beatsService;

    @Autowired
    Logger logger;


    @GetMapping("/shop")
    public String getShopPage(Model model,
                               @PageableDefault(sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable){
        try {
            model.addAttribute("page",beatsService.getAllPaginatedBeats(pageable));
            model.addAttribute("url","/shop");
            return "shop";
        } catch (BeatNotFoundException e) {
            logger.error("error",e);
            return "error";
        }
    }

}

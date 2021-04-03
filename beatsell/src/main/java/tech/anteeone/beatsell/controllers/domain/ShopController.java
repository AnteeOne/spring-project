package tech.anteeone.beatsell.controllers.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ShopController {

    @GetMapping("/shop")
    private String getShopPage(){
        return "shop";
    }

}

package tech.anteeone.beatsell.controllers.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    private String getIndexPage(){
        return "index";
    }

}

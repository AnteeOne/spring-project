package tech.anteeone.beatsell.controllers.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class AdminController {

    @GetMapping("/admin")
    private String getAdminIndexPage(Model model, Principal principal){
        model.addAttribute("user", principal);
        return "admin_index";
    }

    @GetMapping("/admin/profile")
    private String getAdminProfile(Model model, Principal principal){
        model.addAttribute("user", principal);
        return "admin_profile";
    }

    @GetMapping("/admin/tables")
    private String getAdminTablesPage(Model model, Principal principal){
        model.addAttribute("user", principal);
        return "admin_tables";
    }

}

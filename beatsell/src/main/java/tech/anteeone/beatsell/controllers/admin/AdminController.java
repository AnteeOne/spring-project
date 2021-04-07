package tech.anteeone.beatsell.controllers.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import tech.anteeone.beatsell.exceptions.UserNotFoundException;
import tech.anteeone.beatsell.repositories.jpa.LicensesRepository;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;
import tech.anteeone.beatsell.services.domain.interfaces.LicensesService;
import tech.anteeone.beatsell.services.domain.interfaces.UserService;

import java.security.Principal;

@Controller
public class AdminController {

    @Autowired
    BeatsService beatsService;

    @Autowired
    UserService userService;

    @Autowired
    LicensesService licensesService;

    @GetMapping("/admin")
    private String getAdminIndexPage(Model model , Principal principal) {
        try {
//            model.addAttribute("user" , userService.findByEmail(principal.getName()));
            model.addAttribute("bookingsCount",beatsService.getBookingsCount());
            model.addAttribute("licensesList",licensesService.getLicenses());
            return "admin_index";
        }
        //todo
//        catch (UserNotFoundException e){
//            e.printStackTrace();
//            return "error";
//
//        }
        catch (Exception e){
            e.printStackTrace();
            return "error";

        }
    }

    @GetMapping("/admin/profile")
    private String getAdminProfile(Model model , Principal principal) {
        model.addAttribute("user" , principal);
        return "admin_profile";
    }

    @GetMapping("/admin/tables")
    private String getAdminTablesPage(Model model , Principal principal) {
        model.addAttribute("user" , principal);
        return "admin_tables";
    }

}

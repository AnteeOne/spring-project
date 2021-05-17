package tech.anteeone.beatsell.controllers.admin;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import tech.anteeone.beatsell.dto.BeatDto;
import tech.anteeone.beatsell.dto.LicenseDto;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;
import tech.anteeone.beatsell.services.domain.interfaces.LicensesService;
import tech.anteeone.beatsell.services.domain.interfaces.UserService;
import tech.anteeone.beatsell.services.validation.interfaces.ValidationUtilsService;
import static tech.anteeone.beatsell.controllers.admin.AdminControllerUtils.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AdminController {

    @Autowired
    BeatsService beatsService;

    @Autowired
    UserService userService;

    @Autowired
    LicensesService licensesService;

    @Autowired
    ValidationUtilsService validationUtils;

    @Autowired
    Logger logger;

    @GetMapping("/admin")
    public String getAdminIndexPage(Model model) {
        try {
            model.addAttribute("bookingsCount",beatsService.getBookingsCount());
            model.addAttribute("licensesList",licensesService.getLicenses());
            return "admin_index";
        }
        catch (Exception e){
            logger.error("error",e);
            return "error";

        }
    }

    @GetMapping("/admin/profile")
    public String getAdminProfile(Model model , Principal principal) {
        model.addAttribute("user" , principal);
        return "admin_profile";
    }

    @GetMapping("/admin/tables")
    public String getAdminTablesPage(Model model , Principal principal) {
        model.addAttribute("user" , principal);
        try {
            saveListsInPageArgs(model,beatsService,licensesService);
            return "admin_tables";
        }
        catch (Exception e){
            logger.error("error",e);
            return "error";

        }
    }

    @PostMapping(value = "/admin/tables",name = "save_beat",params = {"savebeat"})
    public String saveBeat(@Valid BeatDto beatDto,
                            BindingResult bindingResult,
                            Model model){
        try {
            if(bindingResult.hasErrors()){
                saveListsInPageArgs(model,beatsService,licensesService);
                loadFormResult(model,false,"beat");
                return "admin_tables";
            }
            loadFormResult(model,true,"beat");
            beatsService.saveBeat(beatDto);
            return "redirect:";
        }
        catch (Exception e){
            logger.error("error",e);
            return "error";
        }
    }

    @PostMapping(value = "/admin/tables",name = "save_license",params = {"savelicense"})
    public String saveLicense(@Valid LicenseDto licenseDto,
                               BindingResult bindingResult,
                               Model model){
        try {
            if(bindingResult.hasErrors()){
                saveListsInPageArgs(model,beatsService,licensesService);
                loadFormResult(model,false,"license");
                return "admin_tables";
            }
            loadFormResult(model,true,"license");
            licensesService.saveLicense(licenseDto);
            return "redirect:";
        }
        catch (Exception e){
            logger.error("error",e);
            return "error";
        }

    }




}

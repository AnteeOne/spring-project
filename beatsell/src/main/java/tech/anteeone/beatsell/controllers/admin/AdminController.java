package tech.anteeone.beatsell.controllers.admin;

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
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;

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
        try {
//            model.addAttribute("user" , userService.findByEmail(principal.getName()));
            savePageArgs(model);
            return "admin_tables";
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

    @PostMapping(value = "/admin/tables",name = "save_beat",params = {"savebeat"})
    private String saveBeat(@Valid BeatDto beatDto,
                            BindingResult bindingResult,
                            Model model){
        try {
            if(bindingResult.hasErrors()){
                savePageArgs(model);
                saveResult(model,false,"beat");
                return "admin_tables";
            }
            saveResult(model,true,"beat");
            return "redirect:";
        }
        catch (Exception e){
            //todo
            e.printStackTrace();
            return "error";
        }
    }

    @PostMapping(value = "/admin/tables",name = "save_license",params = {"savelicense"})
    private String saveLicense(@Valid LicenseDto licenseDto,
                               BindingResult bindingResult,
                               Model model){
        try {
            if(bindingResult.hasErrors()){
                savePageArgs(model);
                saveResult(model,false,"license");
                return "admin_tables";
            }
            saveResult(model,true,"license");
            return "redirect:";
        }
        catch (Exception e){
            //todo
            e.printStackTrace();
            return "error";
        }

    }

    private void savePageArgs(Model model) throws BeatNotFoundException {
        model.addAttribute("beatsList",beatsService.getAllBeats());
        model.addAttribute("licensesList",licensesService.getLicenses());
    }

    private void saveResult(Model model,boolean isSuccess,String flag){
        if(isSuccess){
            model.addAttribute(flag + "Flag ",isSuccess);
        }
        else{
            model.addAttribute("_" + flag + "Flag",isSuccess);
        }
    }


}

package tech.anteeone.beatsell.controllers.admin;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tech.anteeone.beatsell.dto.LicenseDto;
import tech.anteeone.beatsell.models.License;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;
import tech.anteeone.beatsell.services.domain.interfaces.LicensesService;
import tech.anteeone.beatsell.utils.exceptions.LicenseNotFoundException;

import static tech.anteeone.beatsell.controllers.admin.AdminControllerUtils.*;

import javax.validation.Valid;
import java.security.Principal;

@Controller
public class AdminLicenseDetailController {

    @Autowired
    LicensesService licensesService;

    @Autowired
    BeatsService beatsService;

    @Autowired
    Logger logger;

    @GetMapping("/admin/tables/license/{licenseid}")
    public String getLicenseDetailPage(@PathVariable String licenseid ,
                                        Model model ,
                                        Principal principal
    ) {
        try {
            License license = licensesService.getLicenseById(licenseid);
            model.addAttribute("license" , license);
            if (license.isForProfit()) model.addAttribute("isProfit" , "");
            if (license.isForMusicRecording()) model.addAttribute("isForMusicRecording" , "");
            return "admin_license_detail";
        } catch (LicenseNotFoundException e) {
            logger.error("error" , e);
            return "error";
        }
    }

    @PostMapping(value = "/admin/tables/license/{licenseid}", name = "save_license", params = {"savelicense"})
    public String saveLicense(@PathVariable String licenseid ,
                               @Valid LicenseDto licenseDto ,
                               BindingResult bindingResult ,
                               Model model) {
        try {
            if (bindingResult.hasErrors()) {
                loadFormResult(model , false , "license");
                License license = licensesService.getLicenseById(licenseid);
                model.addAttribute("license" , license);
                return "admin_license_detail";
            }
            else {
                loadFormResult(model , true , "license");
                licensesService.updateLicense(licenseDto , licenseid);
                return "redirect:/admin/tables";
            }
        } catch (LicenseNotFoundException e) {
            logger.error("error" , e);
            return "error";
        }
    }

    @PostMapping(value = "/admin/tables/license/{licenseid}", name = "delete_license", params = {"deletelicense"})
    public String deleteLicense(@PathVariable String licenseid) {
        try {
            licensesService.deleteLicenseById(licenseid);
            return "redirect:/admin/tables";
        } catch (LicenseNotFoundException e) {
            logger.error("error" , e);
            return "error";
        }
    }
}

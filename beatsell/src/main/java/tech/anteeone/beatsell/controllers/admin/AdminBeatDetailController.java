package tech.anteeone.beatsell.controllers.admin;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import tech.anteeone.beatsell.dto.BeatDto;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;
import tech.anteeone.beatsell.services.domain.interfaces.LicensesService;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;

import javax.validation.Valid;
import java.security.Principal;

import static tech.anteeone.beatsell.controllers.admin.AdminControllerUtils.loadFormResult;

@Controller
public class AdminBeatDetailController {

    @Autowired
    BeatsService beatsService;

    @Autowired
    LicensesService licensesService;
    
    @Autowired
    Logger logger;

    @GetMapping("/admin/tables/beat/{beatid}")
    public String getBeatDetailPage(@PathVariable String beatid,
                                     Model model,
                                     Principal principal
    ){
        try {
            model.addAttribute("licensesList",licensesService.getLicenses());
            model.addAttribute("beat",beatsService.getBeatById(beatid));
            return "admin_beat_detail";
        }
        catch (BeatNotFoundException e){
            logger.error("Beat not found",e);
            return "error";
        }
    }

    @PostMapping(value = "/admin/tables/beat/{beatid}",name = "save_beat",params = {"savebeat"})
    public String saveBeat(@PathVariable String beatid,
                               @Valid BeatDto beatDto,
                               BindingResult bindingResult,
                               Model model){
        try {
            if(bindingResult.hasErrors()){
                loadFormResult(model,false,"beat");
                model.addAttribute("licensesList",licensesService.getLicenses());
                model.addAttribute("beat",beatsService.getBeatById(beatid));
                return "admin_beat_detail";
            }
            loadFormResult(model,true,"beat");
            beatsService.updateBeat(beatDto,beatid);
            return "redirect:/admin/tables";
        }
        catch (BeatNotFoundException e){
            logger.error("error",e);
            return "error";
        }
    }
    @PostMapping(value = "/admin/tables/beat/{beatid}",name = "delete_beat",params = {"deletebeat"})
    public String deleteBeat(@PathVariable String beatid){
        try {
            beatsService.deleteBeatById(beatid);
            return "redirect:/admin/tables";
        } catch (BeatNotFoundException e) {
            logger.error("error",e);
            return "error";
        }
    }

}

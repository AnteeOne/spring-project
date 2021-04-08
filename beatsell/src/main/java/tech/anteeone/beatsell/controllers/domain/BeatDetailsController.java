package tech.anteeone.beatsell.controllers.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;

import java.security.Principal;

@Controller
public class BeatDetailsController {

    @Autowired
    BeatsService beatsService;


    @GetMapping("/beats/{beatid}")
    private String getBeatDetailPage(@PathVariable String beatid,
                                     Model model,
                                     Principal principal
    ){
        try {
            model.addAttribute("beat",beatsService.getBeatById(beatid));
            model.addAttribute("bookingCount",beatsService.getBeatById(beatid).getBookedUsers().size());
            model.addAttribute("bookingStatus",beatsService.beatIsBookedByUser(beatid, principal.getName()));
        }
        catch (BeatNotFoundException e){
            e.printStackTrace();
        }

        return "beat_details";
    }

    @GetMapping("/beats/book/{beatid}")
    private String bookBeat(@PathVariable String beatid,
                          Model model,
                          Principal principal){

        try {
            beatsService.book(beatid,principal.getName());
        } catch (BeatNotFoundException e) {
            e.printStackTrace();
        }

        return "redirect:/beats/{beatid}";

    }

    @GetMapping("/beats/unbook/{beatid}")
    private String unbookBeat(@PathVariable String beatid,
                            Model model,
                            Principal principal){
        try {
            beatsService.unbook(beatid,principal.getName());
        } catch (BeatNotFoundException e) {
            e.printStackTrace();
        }
        return "redirect:/beats/{beatid}";

    }
}

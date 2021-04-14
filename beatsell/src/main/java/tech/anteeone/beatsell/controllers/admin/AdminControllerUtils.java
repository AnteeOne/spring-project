package tech.anteeone.beatsell.controllers.admin;

import org.springframework.ui.Model;
import tech.anteeone.beatsell.models.Beat;
import tech.anteeone.beatsell.models.License;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;
import tech.anteeone.beatsell.services.domain.interfaces.LicensesService;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;

public class AdminControllerUtils {

    public static void saveListsInPageArgs(Model model,
                                           BeatsService beatsService,
                                           LicensesService licensesService
    ) throws BeatNotFoundException {
        model.addAttribute("beatsList",beatsService.getAllBeats());
        model.addAttribute("licensesList",licensesService.getLicenses());
    }

    public static void loadFormResult(Model model, boolean isSuccess, String flag){
        if(isSuccess){
            model.addAttribute(flag + "Flag ",isSuccess);
        }
        else{
            model.addAttribute("_" + flag + "Flag",isSuccess);
        }
    }

    public static void updateData(License o, License n){
        o.setAudioStreamsCount(n.getAudioStreamsCount());
        o.setDistributionCopiesCount(n.getDistributionCopiesCount());
        o.setRadioStationsCount(n.getRadioStationsCount());
        o.setPrice(n.getPrice());
        o.setForMusicRecording(n.isForMusicRecording());
        o.setMusicVideoCount(n.getMusicVideoCount());
        o.setTitle(n.getTitle());
        o.setTrackFile(n.getTrackFile());
        o.setForProfit(n.isForProfit());
    }

    public static void updateData(Beat o, Beat n){
        o.setBpm(n.getBpm());
        o.setLicenses(n.getLicenses());
        o.setMood(n.getMood());
        o.setSoundCloudId(n.getSoundCloudId());
        o.setTags(n.getTags());
        o.setTitle(n.getTitle());
        o.setState(n.getState());
    }

}

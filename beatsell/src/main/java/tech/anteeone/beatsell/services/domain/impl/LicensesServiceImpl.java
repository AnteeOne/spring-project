package tech.anteeone.beatsell.services.domain.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.anteeone.beatsell.controllers.admin.AdminController;
import tech.anteeone.beatsell.controllers.admin.AdminControllerUtils;
import tech.anteeone.beatsell.dto.LicenseDto;
import tech.anteeone.beatsell.models.License;
import tech.anteeone.beatsell.repositories.jpa.LicensesRepository;
import tech.anteeone.beatsell.services.domain.interfaces.LicensesService;
import tech.anteeone.beatsell.utils.exceptions.LicenseNotFoundException;

import java.util.HashMap;

@Component
public class LicensesServiceImpl implements LicensesService {

    @Autowired
    LicensesRepository licensesRepository;


    @Override
    public List<License> getLicenses() {
        return licensesRepository.findAll();
    }

    @Override
    public void saveLicense(LicenseDto dto) {
        try {
            License license = License.builder()
                    .audioStreamsCount(dto.getAudioStreamsCount())
                    .distributionCopiesCount(dto.getDistributionCopiesCount())
                    .isForMusicRecording(dto.isForMusicRecording())
                    .isForProfit(dto.isForProfit())
                    .musicVideoCount(dto.getMusicVideoCount())
                    .price(dto.getPrice())
                    .radioStationsCount(dto.getRadioStationsCount())
                    .title(dto.getTitle())
                    .trackFile(License.TrackFile.valueOf(dto.getTrackFile()))
                    .build();
            licensesRepository.save(license);
        }
        catch (Exception e){
            //todo
        }
    }

    @Override
    public void updateLicense(LicenseDto dto,String id) throws LicenseNotFoundException {
        try {
            License licenseForUpdate = License.builder()
                    .audioStreamsCount(dto.getAudioStreamsCount())
                    .distributionCopiesCount(dto.getDistributionCopiesCount())
                    .isForMusicRecording(dto.isForMusicRecording())
                    .isForProfit(dto.isForProfit())
                    .musicVideoCount(dto.getMusicVideoCount())
                    .price(dto.getPrice())
                    .radioStationsCount(dto.getRadioStationsCount())
                    .title(dto.getTitle())
                    .trackFile(License.TrackFile.valueOf(dto.getTrackFile()))
                    .build();
            License oldLicense = licensesRepository.findById(Long.parseLong(id)).orElseThrow(IllegalStateException::new);
            AdminControllerUtils.updateData(oldLicense,licenseForUpdate);
            licensesRepository.save(oldLicense);
        }
        catch (Exception e){
            throw new LicenseNotFoundException();
        }
    }

    @Override
    public License getLicenseById(String licenseId) throws LicenseNotFoundException {
        try {
            return licensesRepository.findById(Long.parseLong(licenseId)).orElseThrow(IllegalStateException::new);
        }
        catch (Exception e){
            throw new LicenseNotFoundException(e);
        }
    }

    @Override
    public void deleteLicenseById(String licenseId) throws LicenseNotFoundException {
        try {
            licensesRepository.deleteLicensePinnedBeats(Long.parseLong(licenseId));
            licensesRepository.deleteById(Long.parseLong(licenseId));
        }
        catch (Exception e){
            throw new LicenseNotFoundException(e);
        }

    }
}

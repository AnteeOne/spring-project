package tech.anteeone.beatsell.services.domain.interfaces;

import java.util.List;

import tech.anteeone.beatsell.dto.LicenseDto;
import tech.anteeone.beatsell.models.License;
import tech.anteeone.beatsell.utils.exceptions.LicenseNotFoundException;

import java.util.HashMap;

public interface LicensesService {

    List<License> getLicenses();

    void saveLicense(LicenseDto licenseDto);

    License getLicenseById(String licenseId) throws LicenseNotFoundException;

    void updateLicense(LicenseDto licenseDto,String id) throws LicenseNotFoundException;

    void deleteLicenseById(String licenseId) throws LicenseNotFoundException;
}

package tech.anteeone.beatsell.services.domain.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.anteeone.beatsell.models.License;
import tech.anteeone.beatsell.repositories.jpa.LicensesRepository;
import tech.anteeone.beatsell.services.domain.interfaces.LicensesService;

import java.util.HashMap;

@Component
public class LicensesServiceImpl implements LicensesService {

    @Autowired
    LicensesRepository licensesRepository;

    @Override
    public List<License> getLicenses() {
        return licensesRepository.findAll();
    }
}

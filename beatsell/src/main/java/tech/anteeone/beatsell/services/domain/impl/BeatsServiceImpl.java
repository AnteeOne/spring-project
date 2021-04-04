package tech.anteeone.beatsell.services.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import tech.anteeone.beatsell.models.Beat;
import tech.anteeone.beatsell.repositories.jpa.BeatsRepository;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;

import java.util.List;

@Component
public class BeatsServiceImpl implements BeatsService {

    @Autowired
    private BeatsRepository repository;

    @Override
    public List<Beat> getAllBeats() {
        return repository.findAll();
    }
}

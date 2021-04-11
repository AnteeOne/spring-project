package tech.anteeone.beatsell.services.domain.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.anteeone.beatsell.models.rest.RestBeat;
import tech.anteeone.beatsell.repositories.jpa.BeatsRepository;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;
import tech.anteeone.beatsell.services.domain.interfaces.RestBeatsService;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;

import java.util.stream.Collectors;

@Component
public class RestBeatsServiceImpl implements RestBeatsService {

    @Autowired
    BeatsService beatsService;

    @Autowired
    BeatsRepository beatsRepository;

    @Override
    public List<RestBeat> getAll() throws BeatNotFoundException {
        return beatsService.getAllBeats().stream().map(beat -> beat.getRestBeat()).collect(Collectors.toList());
    }

    @Override
    public RestBeat getDetail(String id) throws BeatNotFoundException {
        return beatsService.getBeatById(id).getRestBeat();
    }

    @Override
    public void add(RestBeat beat) {
      //todo
    }
}

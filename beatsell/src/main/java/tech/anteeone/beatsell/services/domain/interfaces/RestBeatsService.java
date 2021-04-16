package tech.anteeone.beatsell.services.domain.interfaces;

import java.util.List;

import tech.anteeone.beatsell.dto.BeatDto;
import tech.anteeone.beatsell.models.rest.RestBeat;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;

public interface RestBeatsService {

    List<RestBeat> getAll() throws BeatNotFoundException;

    RestBeat getDetail(String id) throws BeatNotFoundException;

    void add(BeatDto dto);

    void update(BeatDto dto,String beatId) throws BeatNotFoundException;

}

package tech.anteeone.beatsell.services.domain.interfaces;

import tech.anteeone.beatsell.dto.BeatDto;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;
import tech.anteeone.beatsell.models.Beat;

import java.util.List;

public interface BeatsService {

    List<Beat> getAllBeats() throws BeatNotFoundException;

    Integer getBookingsCount();

    List<Beat> getAllUserBookedBeats(String username) throws BeatNotFoundException;

    Beat getBeatById(String id) throws BeatNotFoundException;

    void book(String beatId,String username) throws BeatNotFoundException;

    void unbook(String beatId,String username) throws BeatNotFoundException;

    boolean beatIsBookedByUser(String beatid,String username) throws BeatNotFoundException;

    void saveBeat(BeatDto beatDto);

    void updateBeat(BeatDto beatDto,String id) throws BeatNotFoundException;

    void deleteBeatById(String beatId) throws BeatNotFoundException;
}

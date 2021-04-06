package tech.anteeone.beatsell.services.domain.interfaces;

import org.springframework.ui.Model;
import tech.anteeone.beatsell.exceptions.BeatNotFoundException;
import tech.anteeone.beatsell.models.Beat;

import java.util.List;

public interface BeatsService {

    List<Beat> getAllBeats();

    Beat getBeatById(String id) throws BeatNotFoundException;

    void book(String beatId,String username) throws BeatNotFoundException;

    void unbook(String beatId,String username) throws BeatNotFoundException;

    boolean beatIsBookedByUser(String beatid,String username) throws BeatNotFoundException;

}

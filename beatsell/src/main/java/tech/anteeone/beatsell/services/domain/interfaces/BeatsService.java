package tech.anteeone.beatsell.services.domain.interfaces;

import org.springframework.ui.Model;
import tech.anteeone.beatsell.models.Beat;

import java.util.List;

public interface BeatsService {

    List<Beat> getAllBeats();

}

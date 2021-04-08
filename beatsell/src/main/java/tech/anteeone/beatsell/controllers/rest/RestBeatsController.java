package tech.anteeone.beatsell.controllers.rest;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import tech.anteeone.beatsell.models.Beat;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;

@Controller
public class RestBeatsController {

    @Autowired
    BeatsService beatsService;

    @GetMapping("/api/v1/beats")
    public ResponseEntity<List<Beat>> getAllBeats(){
        try {
            return ResponseEntity.ok(beatsService.getAllBeats());
        } catch (BeatNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
    @GetMapping("/api/v1/beats/{beatId}")
    public ResponseEntity<Beat> getBeatsDetail(@PathVariable("beatId") String beatId){
        try {
            ResponseEntity<Beat> responseEntity = ResponseEntity.ok(beatsService.getBeatById(beatId));
            return ResponseEntity.ok(beatsService.getBeatById(beatId));
        } catch (BeatNotFoundException e) {
            e.printStackTrace();
            return ResponseEntity.ok(Beat.builder().build());
        }
    }

}

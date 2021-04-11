package tech.anteeone.beatsell.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.anteeone.beatsell.models.rest.RestBeat;
import tech.anteeone.beatsell.services.domain.interfaces.RestBeatsService;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;

import java.util.Collections;
import java.util.List;

@Controller
public class RestBeatsController {

    @Autowired
    RestBeatsService restBeatsService;

    @GetMapping("/api/v1/beats")
    @ResponseBody
    public ResponseEntity<List<RestBeat>> getAllBeats(){
        try {
            return ResponseEntity.ok(restBeatsService.getAll());
        } catch (BeatNotFoundException e) {
//            e.printStackTrace();
            return ResponseEntity.ok(Collections.emptyList());
        }
    }
    @GetMapping("/api/v1/beats/{beatId}")
    @ResponseBody
    public ResponseEntity<RestBeat> getBeatsDetail(@PathVariable("beatId") String beatId){
        try {
            return ResponseEntity.ok(restBeatsService.getDetail(beatId));
        } catch (BeatNotFoundException e) {
//            e.printStackTrace();
            return ResponseEntity.ok(null);
        }
    }


}

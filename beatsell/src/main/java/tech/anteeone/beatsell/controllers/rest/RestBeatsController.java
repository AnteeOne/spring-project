package tech.anteeone.beatsell.controllers.rest;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tech.anteeone.beatsell.dto.BeatDto;
import tech.anteeone.beatsell.models.rest.RestBeat;
import tech.anteeone.beatsell.services.domain.interfaces.RestBeatsService;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;

@Controller
public class RestBeatsController {

    @Autowired
    RestBeatsService restBeatsService;

    @Autowired
    Logger logger;


    @GetMapping("/api/v1/beats")
    @ResponseBody
    public ResponseEntity<List<RestBeat>> getAllBeats() {
        try {
            logger.info("Getting all beats");
            return ResponseEntity.ok(restBeatsService.getAll());
        } catch (BeatNotFoundException e) {
            logger.error("error" , e);
            return ResponseEntity.ok(Collections.emptyList());
        }
    }

    @PostMapping("/api/v1/beats/add")
    @ResponseBody
    public ResponseEntity<String> addBeat(@Valid @RequestBody BeatDto dto ,
                                          BindingResult bindingResult) {

        if (!bindingResult.hasErrors()) {
            restBeatsService.add(dto);
            return ResponseEntity.status(HttpStatus.ACCEPTED).build();
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/api/v1/beats/{beatId}")
    @ResponseBody
    public ResponseEntity<RestBeat> getBeatsDetail(@PathVariable("beatId") String beatId) {
        try {
            return ResponseEntity.ok(restBeatsService.getDetail(beatId));
        } catch (BeatNotFoundException e) {
            logger.error("error" , e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/api/v1/beats/{beatId}")
    @ResponseBody
    public ResponseEntity<RestBeat> updateBeat(@PathVariable("beatId") String beatId ,
                                               @Valid @RequestBody BeatDto dto ,
                                               BindingResult bindingResult) {
        try {
            if (!bindingResult.hasErrors()) {
                restBeatsService.update(dto , beatId);
                return ResponseEntity.ok(restBeatsService.getDetail(beatId));
            } else {
                return ResponseEntity.status(400).body(restBeatsService.getDetail(beatId));
            }

        } catch (BeatNotFoundException e) {
            logger.error("error" , e);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


}

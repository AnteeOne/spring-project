package tech.anteeone.beatsell.controllers.api;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.anteeone.beatsell.repositories.api.ApiRepository;
import tech.anteeone.beatsell.utils.exceptions.ApiException;

@RestController
public class ApiController {

    @Autowired
    ApiRepository apiRepository;

    @Autowired
    Logger logger;

    @GetMapping("/randomgenre")
    public ResponseEntity<String> getRandomGenre(){
        try {
            return ResponseEntity.ok(apiRepository.get());
        }
        catch (ApiException e){
            logger.error("Api Error",e);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

    }
}

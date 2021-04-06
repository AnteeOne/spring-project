package tech.anteeone.beatsell.services.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.anteeone.beatsell.exceptions.BeatNotFoundException;
import tech.anteeone.beatsell.models.Beat;
import tech.anteeone.beatsell.repositories.jpa.BeatsRepository;
import tech.anteeone.beatsell.repositories.jpa.UsersRepository;
import tech.anteeone.beatsell.services.domain.interfaces.BeatsService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class BeatsServiceImpl implements BeatsService {

    @Autowired
    private BeatsRepository beatsRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public List<Beat> getAllBeats() throws BeatNotFoundException {
        try {
            return beatsRepository.findAll();
        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }

    }

    @Override
    public List<Beat> getAllUserBookedBeats(String username) throws BeatNotFoundException {
        try {
            return beatsRepository.findAllBeatsBookedByUser(usersRepository.findByEmail(username).get().getId());
        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }
    }

    @Override
    public Beat getBeatById(String id) throws BeatNotFoundException {
        try {
            Long parsedId = Long.parseLong(id);
            return beatsRepository.findById(parsedId).get();
        }
        catch (NumberFormatException e){
            throw new BeatNotFoundException(e);
        }
    }

    @Override
    public void book(String beatId , String username) throws BeatNotFoundException {
        try {
            if (!beatIsBookedByUser(beatId,username))
            usersRepository.bookBeatForUser(
                    Long.parseLong(beatId),
                    usersRepository.findByEmail(username).get().getId()
            );
        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }

    }

    @Override
    public void unbook(String beatId , String username) throws BeatNotFoundException {
        try {
            if (beatIsBookedByUser(beatId,username))
            usersRepository.unbookBeatForUser(
                    Long.parseLong(beatId),
                    usersRepository.findByEmail(username).get().getId()
            );
        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }

    }

    @Override
    public boolean beatIsBookedByUser(String beatid,String username) throws BeatNotFoundException {
        try {
            boolean result = usersRepository.findByEmail(username).get().getBookedBeats()
                    .stream()
                    .map(x -> x.getId())
                    .collect(Collectors.toList())
                    .contains(Long.parseLong(beatid));
            return result;
        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }

    }
}

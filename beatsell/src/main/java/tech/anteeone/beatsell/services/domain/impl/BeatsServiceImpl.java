package tech.anteeone.beatsell.services.domain.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import tech.anteeone.beatsell.controllers.admin.AdminControllerUtils;
import tech.anteeone.beatsell.dto.BeatDto;
import tech.anteeone.beatsell.repositories.api.ApiRepository;
import tech.anteeone.beatsell.repositories.jpa.LicensesRepository;
import tech.anteeone.beatsell.utils.exceptions.BeatNotFoundException;
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

    @Autowired
    private LicensesRepository licensesRepository;

    @Autowired
    private ConversionService conversionService;

    @Autowired
    private ApiRepository apiRepository;

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
    public Page<Beat> getAllPaginatedBeats(Pageable pageable) throws BeatNotFoundException {
        try {
            return beatsRepository.findAll(pageable);
        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }
    }

    @Override
    public Integer getBookingsCount() {
        return beatsRepository.getBookingsCount();
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
    public Beat getBeatById(String beatId) throws BeatNotFoundException {
        try {
            Long parsedId = Long.parseLong(beatId);
            return beatsRepository.findById(parsedId).get();
        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }
    }

    @Override
    public void book(String beatId , String username) throws BeatNotFoundException {
        try {
            if (!beatIsBookedByUser(beatId,username)){
                usersRepository.bookBeatForUser(
                        Long.parseLong(beatId),
                        usersRepository.findByEmail(username).get().getId()
                );
                apiRepository.sendSms(beatId + " has been booked by " + username);
            }

        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }

    }

    @Override
    public void saveBeat(BeatDto dto) {
        Beat beat = Beat.builder()
                .mood(Beat.Mood.valueOf(dto.getMood()))
                .bpm(dto.getBpm())
                .soundCloudId(dto.getSoundCloudId())
                .state(Beat.State.valueOf(dto.getState()))
                .title(dto.getTitle())
                .bookingCount(0L)
                .tags(dto.getTags())
                .licenses(dto.getLicenses().stream().map(licenseId -> licensesRepository.findById(licenseId).get()).collect(Collectors.toList()))
                .build();
        beatsRepository.save(beat);
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

    @Override
    public void updateBeat(BeatDto beatDto , String id) throws BeatNotFoundException {
        try {
            Beat beat = Beat.builder()
                    .title(beatDto.getTitle())
                    .tags(beatDto.getTags())
                    .state(Beat.State.valueOf(beatDto.getState()))
                    .mood(Beat.Mood.valueOf(beatDto.getMood()))
                    .bpm(beatDto.getBpm())
                    .soundCloudId(beatDto.getSoundCloudId())
                    .licenses(beatDto.getLicenses().stream().map(
                            licenseId -> licensesRepository
                            .findById(licenseId)
                            .orElseThrow(IllegalStateException::new)
                    ).collect(Collectors.toList()))
                    .build();
            Beat oldBeat = beatsRepository.findById(Long.parseLong(id)).orElseThrow(IllegalStateException::new);
            AdminControllerUtils.updateData(oldBeat,beat);
            beatsRepository.save(oldBeat);
        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }

    }

    @Override
    public void deleteBeatById(String beatId) throws BeatNotFoundException {
        try {
            beatsRepository.deleteBeatPinnedUsers(Long.parseLong(beatId));
            beatsRepository.deleteById(Long.parseLong(beatId));
        }
        catch (Exception e){
            throw new BeatNotFoundException(e);
        }
    }
}

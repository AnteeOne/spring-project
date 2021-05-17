package tech.anteeone.beatsell.utils.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import tech.anteeone.beatsell.dto.BeatDto;
import tech.anteeone.beatsell.models.Beat;
import tech.anteeone.beatsell.repositories.jpa.LicensesRepository;

import java.util.stream.Collectors;

public class BeatDtoToBeatConverter implements Converter<BeatDto, Beat> {

    @Autowired
    LicensesRepository licensesRepository;

    @Override
    public Beat convert(BeatDto dto) {
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
        return beat;
    }
}

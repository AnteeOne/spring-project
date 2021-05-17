package tech.anteeone.beatsell.utils.converters;

import org.springframework.core.convert.converter.Converter;
import tech.anteeone.beatsell.models.Beat;
import tech.anteeone.beatsell.models.rest.RestBeat;

public class BeatToRestBeatConverter implements Converter<Beat, RestBeat> {

    @Override
    public RestBeat convert(Beat beat) {
        return new RestBeat(beat);
    }

}

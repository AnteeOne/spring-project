package tech.anteeone.beatsell.utils.converters;

import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class ConverterConfiguration implements WebMvcConfigurer {

    @Override
    public void addFormatters(FormatterRegistry registry) {
        registry.addConverter(new BeatToRestBeatConverter());
        registry.addConverter(new BeatDtoToBeatConverter());
    }
}

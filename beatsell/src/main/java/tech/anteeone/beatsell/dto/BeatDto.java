package tech.anteeone.beatsell.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class BeatDto {
    @NotNull(message = "Please fill the title")
    private String title;
    @NotNull(message = "Please fill the tags")
    private String tags;
    @NotNull(message = "Please fill the bpm")
    private Integer bpm;
    @NotNull(message = "Please fill the mood")
    private String mood;
    @NotNull(message = "Please fill the SoundCloud ID")
    private String soundCloudId;
    @NotNull(message = "Please fill the state")
    private String state;
    @NotNull(message = "Please fill the licenses")
    private List<Long> licenses;


}

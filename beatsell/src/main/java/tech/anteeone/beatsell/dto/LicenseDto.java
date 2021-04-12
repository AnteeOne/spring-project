package tech.anteeone.beatsell.dto;

import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

@Data
public class LicenseDto {

    @NotNull
    private String title;
    @NotNull
    private Long price;
    @NotNull
    private boolean isForProfit;
    @NotNull
    private boolean isForMusicRecording;
    @NotNull
    private Long audioStreamsCount;
    @NotNull
    private Long distributionCopiesCount;
    @NotNull
    private Long musicVideoCount;
    @NotNull
    private Long radioStationsCount;
    @NotNull
    private String trackFile;



}

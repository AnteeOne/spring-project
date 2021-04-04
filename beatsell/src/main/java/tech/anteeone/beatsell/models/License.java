package tech.anteeone.beatsell.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "licenses")
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private Long price;

    private boolean isForProfit;

    private boolean isForMusicRecording;

    private Long audioStreamsCount;

    private Long distributionCopiesCount;

    private Long musicVideoCount;

    private Long radioStationsCount;

    private TrackFile trackFile;

    public enum TrackFile{
        TAGGED_MP3,
        MP3,
        WAV,
        MP3_AND_WAV,
        TRACKOUT,
    }

}

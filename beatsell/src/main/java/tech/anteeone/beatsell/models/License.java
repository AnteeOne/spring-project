package tech.anteeone.beatsell.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @Enumerated(value = EnumType.STRING)
    private TrackFile trackFile;

    @ManyToMany(mappedBy = "licenses")
    private List<Beat> beats;

    public enum TrackFile{
        TAGGED_MP3,
        MP3,
        WAV,
        MP3_and_WAV,
        Trackout,
    }

    public Long getLicenseSells(){
        return beats.size() * price;
    }

    public String getProfitStatus(){
        return isForProfit? "Yes" : "No";
    }

    public String profitToFreemarker(){
        return isForProfit? "true" : "false";
    }

    public String musicToFreemarker(){
        return isForMusicRecording? "true" : "false";
    }

}

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
@Table(name = "beats")
public class Beat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String tags;

    private Integer bpm;

    @Enumerated(value = EnumType.STRING)
    private Mood mood;

    private String soundCloudId;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "beat_id")
    private List<License> licenses;

    private Long bookingCount;

    @ManyToMany(mappedBy = "bookedBeats")
    private List<User> bookedUsers;

    public enum State{
        FREE,
        SOLD
    }

    public enum Mood{
        Chill,
        Dark,
        Sad,
        Party,
        Angry,
        Emotional,
        Soulful,
        Happy,
    }

    public boolean isSold(){
        return this.state == State.SOLD;
    }

    public boolean isBooked(){
        return this.bookingCount > 0;
    }
}

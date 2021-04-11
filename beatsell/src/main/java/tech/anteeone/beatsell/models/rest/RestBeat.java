package tech.anteeone.beatsell.models.rest;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import tech.anteeone.beatsell.models.Beat;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RestBeat {

    public RestBeat(Beat beat) {
        this.id = beat.getId();
        this.title = beat.getTitle();
        this.tags = beat.getTags();
        this.bpm = beat.getBpm();
        this.mood = beat.getMood().name();
        this.soundCloudId = beat.getSoundCloudId();
        this.state = beat.getState().name();
        this.licenses = beat.getLicenses().stream().map(license -> license.getId()).collect(Collectors.toList());
        this.bookingCount = beat.getBookingCount();
        this.bookedUsers = beat.getBookedUsers().stream().map(user -> user.getId()).collect(Collectors.toList());
    }

    private Long id;

    private String title;

    private String tags;

    private Integer bpm;

    private String mood;

    private String soundCloudId;

    private String state;

    private List<Long> licenses;

    private Long bookingCount;

    private List<Long> bookedUsers;


}

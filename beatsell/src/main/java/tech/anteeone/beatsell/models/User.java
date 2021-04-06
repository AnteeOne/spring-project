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
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String email;

    private String hashPassword;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private State state;

    @ManyToMany
    @JoinTable(
            name = "user_booked_beats",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "beat_id", referencedColumnName = "id")
            }
    )
    private List<Beat> bookedBeats;

    public enum Role {
        USER, ADMIN
    }

    public enum State {
        ACTIVE, BANNED
    }

    public boolean isActive() {
        return this.state == State.ACTIVE;
    }

    public boolean isBanned() {
        return this.state == State.BANNED;
    }


    public boolean isAdmin() {
        return this.role == Role.ADMIN;
    }

    public int getBookingCount(){
        return bookedBeats.size();
    }

}

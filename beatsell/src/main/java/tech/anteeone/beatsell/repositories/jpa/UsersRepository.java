package tech.anteeone.beatsell.repositories.jpa;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.anteeone.beatsell.models.User;


import javax.transaction.Transactional;
import java.util.Optional;

public interface UsersRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    @Modifying
    @Transactional
    @Query(value = "INSERT INTO user_booked_beats VALUES (:userid,:beatid) ",nativeQuery = true)
    void bookBeatForUser(@Param("beatid") Long beatid,
                         @Param("userid") Long userid);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM user_booked_beats WHERE user_id = :userid AND beat_id = :beatid",nativeQuery = true)
    void unbookBeatForUser(@Param("beatid") Long beatid,
                         @Param("userid") Long userid);



}

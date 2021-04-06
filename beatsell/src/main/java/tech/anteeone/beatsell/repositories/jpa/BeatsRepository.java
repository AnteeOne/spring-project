package tech.anteeone.beatsell.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.anteeone.beatsell.models.Beat;

import javax.transaction.Transactional;
import java.util.List;

public interface BeatsRepository extends JpaRepository<Beat,Long> {

    @Query(value = "select * from beats where id in  (select beat_id as bigint from user_booked_beats where user_id=:userid);",
            nativeQuery = true)
    @Modifying
    @Transactional
    List<Beat> findAllBeatsBookedByUser(@Param("userid") Long userid);
}

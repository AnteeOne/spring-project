package tech.anteeone.beatsell.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tech.anteeone.beatsell.models.License;

import javax.transaction.Transactional;

public interface LicensesRepository extends JpaRepository<License,Long> {


    @Transactional
    @Modifying
    @Query(value = "DELETE FROM beat_licenses where license_id=:licenseid",nativeQuery = true)
    void deleteLicensePinnedBeats(@Param("licenseid") Long licenseid);

}

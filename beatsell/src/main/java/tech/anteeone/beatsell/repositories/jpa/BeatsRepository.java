package tech.anteeone.beatsell.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.anteeone.beatsell.models.Beat;

public interface BeatsRepository extends JpaRepository<Beat,Long> {

}

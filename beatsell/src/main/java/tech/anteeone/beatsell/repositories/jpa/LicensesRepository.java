package tech.anteeone.beatsell.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.anteeone.beatsell.models.License;

public interface LicensesRepository extends JpaRepository<License,Long> {
}

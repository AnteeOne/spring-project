package tech.anteeone.beatsell.repositories.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.anteeone.beatsell.models.Offer;

public interface OffersRepository extends JpaRepository<Offer,Long> {
}

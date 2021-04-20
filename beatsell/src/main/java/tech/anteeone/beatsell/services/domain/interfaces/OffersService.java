package tech.anteeone.beatsell.services.domain.interfaces;

import java.util.List;
import tech.anteeone.beatsell.models.Offer;
import tech.anteeone.beatsell.utils.exceptions.OfferNotFoundException;

public interface OffersService {

    List<Offer> getAllOffers() throws OfferNotFoundException;

}

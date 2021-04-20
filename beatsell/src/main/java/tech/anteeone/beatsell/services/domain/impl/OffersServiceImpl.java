package tech.anteeone.beatsell.services.domain.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.anteeone.beatsell.models.Offer;
import tech.anteeone.beatsell.repositories.jpa.OffersRepository;
import tech.anteeone.beatsell.services.domain.interfaces.OffersService;
import tech.anteeone.beatsell.utils.exceptions.OfferNotFoundException;

@Service
public class OffersServiceImpl implements OffersService {

    @Autowired
    OffersRepository offersRepository;

    @Override
    public List<Offer> getAllOffers() throws OfferNotFoundException {
        try {
            return offersRepository.findAll();
        }
        catch (Exception e){
            throw new OfferNotFoundException(e);
        }
    }
}

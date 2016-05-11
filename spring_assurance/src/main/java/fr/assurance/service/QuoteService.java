package fr.assurance.service;

import fr.assurance.dao.QuoteRepository;
import fr.assurance.entities.HouseQuote;
import fr.assurance.entities.VehiculeQuote;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Max on 11/05/2016.
 */
@Service
public class QuoteService {

    @Autowired
    private QuoteRepository quoteRepo;

    public VehiculeQuote save(VehiculeQuote quote) {
        return quoteRepo.save(quote);
    }

    public HouseQuote save(HouseQuote quote) {
        return quoteRepo.save(quote);
    }

    public void delete(Integer id) {
        quoteRepo.delete(id);
    }
}

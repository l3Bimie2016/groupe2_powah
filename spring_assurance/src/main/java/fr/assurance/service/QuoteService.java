package fr.assurance.service;

import fr.assurance.dao.QuoteRepository;
import fr.assurance.entities.HouseQuote;
import fr.assurance.entities.Quote;
import fr.assurance.entities.VehiculeQuote;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


	public List<Quote> findByDone(boolean done) {
		return quoteRepo.findByDone(done);
	}

	public Quote findOne(Integer idQuote) {
		return quoteRepo.findOne(idQuote);
	}

}

package fr.assurance.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.assurance.entities.Quote;
import fr.assurance.entities.User;

public interface QuoteRepository extends CrudRepository<Quote, Integer>{
	List<Quote> findAll();
	List<Quote> findByOwnerAndType(User user, String type);
	List<Quote> findByDone(Boolean done);
}

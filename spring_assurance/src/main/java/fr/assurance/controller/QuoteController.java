package fr.assurance.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import fr.assurance.dao.QuoteRepository;
import fr.assurance.entities.Quote;

@Controller
public class QuoteController {
	private QuoteRepository quoteManager;
	
	@RequestMapping(path="/quote", method=RequestMethod.GET)
	public String indexView() {
		System.out.println("-- quoteChoice");
		return "quoteChoice";
	}
	
	@RequestMapping(path="/quote/inProgress", method=RequestMethod.GET)
	public ModelAndView quotesInProgress() {
		List<Quote> quotesList = quoteManager.findByDone(false);
		for (Quote quote : quotesList) {
			System.out.println(quote.getId());
		}
		
		return new ModelAndView("quotesInProgress");
	}
}

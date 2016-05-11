package fr.assurance.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.assurance.entities.Quote;
import fr.assurance.service.QuoteService;

@Controller
@SessionAttributes("quote")
public class QuoteController {
	@Autowired
	private QuoteService quoteManager;
	
	@RequestMapping(path="/quote", method=RequestMethod.GET)
	public String indexView() {
		System.out.println("-- quoteChoice");
		return "quoteChoice";
	}
	
	@RequestMapping(path="/quote/inProgress", method=RequestMethod.GET)
	@ModelAttribute("quote")
	public ModelAndView quotesInProgress() {

		List<Quote> quotesList = quoteManager.findByDone(false);
		
		return new ModelAndView("inProgress", "quotesList", quotesList);
	}
	
	@RequestMapping(path="/quote/resume")
	public ModelAndView quoteResume(@RequestParam("idQuote") Integer idQuote, HttpServletRequest request) {
		Quote quote = quoteManager.findOne(idQuote);
		request.getSession().setAttribute("quote", quote);
		String url = null;
		
		
		if (quote.getType().equals("VehiculeQuote")) {
			url = "/quote/vehicule.form?_page=";
		}
		
		if (quote.getType().equals("HouseQuote")) {
			url = "/quote/home.form?_page=";
		}
		
		return new ModelAndView("redirect:" + url + quote.getStep(), "quote", quote);
	}
}

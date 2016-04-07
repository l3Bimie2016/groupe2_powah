package fr.assurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class QuoteController {
	
	@RequestMapping(path="/quote", method=RequestMethod.GET)
	public String indexView() {
		return "quoteChoice";
	}
	
	@RequestMapping(path="/quote/vehicule", method=RequestMethod.GET)
	public ModelAndView vehiculeView() {
		System.out.println("Coucou");
		return new ModelAndView("createQuoteVehicleStep1");
	}
}

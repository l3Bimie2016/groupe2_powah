package fr.assurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.assurance.dao.QuoteRepository;
import fr.assurance.entities.VehiculeQuote;

@Controller
@RequestMapping("/quote/vehicule.form")
@SessionAttributes("vehiculeQuote")
public class QuoteVehiculeController {
	@Autowired
	private QuoteRepository quoteManager;
	
	private String[] pageViews = new String[] {
			"createQuoteVehicleStep1",
			"createQuoteVehicleStep2",
			"createQuoteVehicleStep3",
			"createQuoteVehicleStep4"
	};
	
	@RequestMapping
	public ModelAndView initialQuoteVehicule() {
		return new ModelAndView("createQuoteVehicleStep1", "vehiculeQuote", new VehiculeQuote());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processPage(@RequestParam("_page") int currentPage, 
			@ModelAttribute("vehiculeQuote") VehiculeQuote vehiculeQuote) {
		
		vehiculeQuote.setStep(currentPage);
		vehiculeQuote = quoteManager.save(vehiculeQuote);
		
		return new ModelAndView(pageViews[currentPage - 1]);
	}
	
	@RequestMapping(params="_finish")
	public ModelAndView processFinish(@ModelAttribute("vehiculeQuote") VehiculeQuote vehiculeQuote,
			SessionStatus status) {
		vehiculeQuote.setDone(true);
		status.setComplete();

		return new ModelAndView("vehiculeQuoteSuccess");
	}
}

package fr.assurance.controller;

import fr.assurance.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.assurance.entities.HouseQuote;

@Controller
@RequestMapping("/quote/home.form")
@SessionAttributes("quote")
public class QuoteHomeController {
	@Autowired
	private QuoteService quoteService;
	
	private String[] pageViews = new String[] {
			"createQuoteHomeStep1",
			"createQuoteHomeStep2",
			"createQuoteHomeStep3",
			"createQuoteHomeStep4"
	};
	
	@RequestMapping
	public ModelAndView initialQuoteVehicule() {
		return new ModelAndView("createQuoteHomeStep1", "quote", new HouseQuote());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processPage(@RequestParam("_page") int currentPage, 
			@ModelAttribute("homeQuote") HouseQuote quote) {

		quote.setStep(currentPage);
		quote = quoteService.save(quote);
		
		return new ModelAndView(pageViews[currentPage - 1]);
	}
	
	@RequestMapping(params="_finish")
	public ModelAndView processFinish(@ModelAttribute("quote") HouseQuote quote,
			SessionStatus status) {
		
		quote.setDone(true);
		quoteService.save(quote);
		status.setComplete();

		return new ModelAndView("homeQuoteSuccess");
	}
	
	@RequestMapping(path="/cancelHomeQuote", method=RequestMethod.POST)
	public ModelAndView cancel(@ModelAttribute("quote") HouseQuote quote) {
		if (quote.getId() != null) {
			quoteService.delete(quote.getId());
		}
		
		return new ModelAndView("index");
	}
}

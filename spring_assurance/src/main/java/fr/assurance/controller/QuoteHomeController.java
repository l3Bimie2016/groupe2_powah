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

import fr.assurance.bean.ApplicationData;
import fr.assurance.dao.QuoteRepository;
import fr.assurance.entities.HouseQuote;;

@Controller
@RequestMapping("/quote/home.form")
@SessionAttributes("quote")
public class QuoteHomeController {
	@Autowired
	private QuoteRepository quoteManager;
	
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
		quote = quoteManager.save(quote);
		
		return new ModelAndView(pageViews[currentPage - 1]);
	}
	
	@RequestMapping(params="_finish")
	public ModelAndView processFinish(@ModelAttribute("quote") HouseQuote quote,
			SessionStatus status) {
		quote.setDone(true);
		quoteManager.save(quote);
		status.setComplete();

		return new ModelAndView("homeQuoteSuccess");
	}
	
	@RequestMapping(path="/cancelHomeQuote", method=RequestMethod.POST)
	public ModelAndView cancel(@ModelAttribute("quote") HouseQuote quote) {
		
		return new ModelAndView("index");
	}
}

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
@SessionAttributes("homeQuote")
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
		return new ModelAndView("createQuoteHomeStep1", "homeQuote", new HouseQuote());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processPage(@RequestParam("_page") int currentPage, 
			@ModelAttribute("homeQuote") HouseQuote homeQuote) {
		
		homeQuote.setStep(currentPage);
		homeQuote = quoteManager.save(homeQuote);
		
		return new ModelAndView(pageViews[currentPage - 1]);
	}
	
	@RequestMapping(params="_finish")
	public ModelAndView processFinish(@ModelAttribute("homeQuote") HouseQuote homeQuote,
			SessionStatus status) {
		homeQuote.setDone(true);
		quoteManager.save(homeQuote);
		status.setComplete();

		return new ModelAndView("homeQuoteSuccess");
	}
	
	@RequestMapping(path="/cancelHomeQuote", method=RequestMethod.POST)
	public ModelAndView cancel(@ModelAttribute("homeQuote") HouseQuote houseQuote) {
		if (houseQuote.getId() != null) {
			quoteManager.delete(houseQuote.getId());
		}
		
		return new ModelAndView("index");
	}
}

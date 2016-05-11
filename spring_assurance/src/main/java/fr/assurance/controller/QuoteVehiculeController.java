package fr.assurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties.Session;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import fr.assurance.bean.ApplicationData;
import fr.assurance.controller.model.VehSummaryMod;
import fr.assurance.dao.QuoteRepository;
import fr.assurance.entities.HouseQuote;
import fr.assurance.entities.VehiculeQuote;
import fr.assurance.service.VertXService;

@Controller
@RequestMapping("/quote/vehicule.form")
@SessionAttributes("quote")
public class QuoteVehiculeController {
	@Autowired
	private QuoteRepository quoteManager;
	
	@Autowired
	private VertXService vertx;
	
	@Autowired
    private ApplicationData appData;
	
	private String[] pageViews = new String[] {
			"createQuoteVehicleStep1",
			"createQuoteVehicleStep2",
			"createQuoteVehicleStep3",
			"createQuoteVehicleStep4"
	};
	
	@RequestMapping
	public ModelAndView initialQuoteVehicule() {
		System.out.println("Ici");
		return new ModelAndView("createQuoteVehicleStep1", "quote", new VehiculeQuote());
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView processPage(@RequestParam("_page") int currentPage, 
			@ModelAttribute("quote") VehiculeQuote quote) {
		System.out.println(quote.getId());
		quote.setStep(currentPage);
		quote = quoteManager.save(quote);
		
		return new ModelAndView(pageViews[currentPage - 1]);
	}
	
	@RequestMapping(params="_finish")
	public ModelAndView processFinish(@ModelAttribute("quote") VehiculeQuote quote,
			SessionStatus status) {
		quote.setDone(true);
		quoteManager.save(quote);
		VehSummaryMod vehSummary = vertx.getSummary(quote);
		quote.setBrand(vehSummary.getBrand());
		quote.setModel(vehSummary.getModel());
		quote.setFiscal_horse_power(vehSummary.getFiscal_horse_power());
		quote.setType_fuel(vehSummary.getType_fuel());
		status.setComplete();

		return new ModelAndView("vehiculeQuoteSuccess");
	}
	
	@RequestMapping(path="/cancelVehiculeQuote", method=RequestMethod.POST)
	public ModelAndView cancel(@ModelAttribute("quote") VehiculeQuote quote, SessionStatus status) {
		status.setComplete();
		
		return new ModelAndView("index");
	}
}

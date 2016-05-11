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

import fr.assurance.controller.model.VehSummaryMod;
import fr.assurance.dao.QuoteRepository;
import fr.assurance.entities.HouseQuote;
import fr.assurance.entities.VehiculeQuote;
import fr.assurance.service.VertXService;

@Controller
@RequestMapping("/quote/vehicule.form")
@SessionAttributes("vehiculeQuote")
public class QuoteVehiculeController {
	@Autowired
	private QuoteService quoteServive;
	
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
		vehiculeQuote = quoteServive.save(vehiculeQuote);
		
		return new ModelAndView(pageViews[currentPage - 1]);
	}
	
	@RequestMapping(params="_finish")
	public ModelAndView processFinish(@ModelAttribute("vehiculeQuote") VehiculeQuote vehiculeQuote,
			SessionStatus status) {
		vehiculeQuote.setDone(true);
		quoteServive.save(vehiculeQuote);
		VertXService vertx = new VertXService();
		VehSummaryMod vehSummary = vertx.getSummary(vehiculeQuote);
		vehiculeQuote.setBrand(vehSummary.getBrand());
		vehiculeQuote.setModel(vehSummary.getModel());
		vehiculeQuote.setFiscal_horse_power(vehSummary.getFiscal_horse_power());
		vehiculeQuote.setType_fuel(vehSummary.getType_fuel());
		status.setComplete();

		return new ModelAndView("vehiculeQuoteSuccess");
	}
	
	@RequestMapping(path="/cancelVehiculeQuote", method=RequestMethod.POST)
	public ModelAndView cancel(@ModelAttribute("vehiculeQuote") VehiculeQuote vehiculeQuote) {
		if (vehiculeQuote.getId() != null) {
			quoteServive.delete(vehiculeQuote.getId());
		}
		
		return new ModelAndView("index");
	}
}

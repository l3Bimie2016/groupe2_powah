package fr.assurance.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/wizard.form")
@SessionAttributes("modelWizard")
public class CreateQuoteVehicleController {


    private String[] pageViews = new String[] {"createQuoteVehicleStep1","createQuoteVehicleStep2", "createQuoteVehicleStep3", "createQuoteVehicleStep4"};

    //Première étape
    @RequestMapping
    public ModelAndView processWizard() {
        return new ModelAndView("wizard/firstStepView","modelWizard","");
    }

    // Renvois de l'étape suivant le numéro d'étape
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView processPage(@RequestParam("_page") int currentPage,
                                    @ModelAttribute("modelWizard") String modelWizard) {
        // pageViews est un tableau qui renvois le nom de la vue suivant le numéro d'étape
        return new ModelAndView("wizard/"+pageViews[currentPage-1]);
    }

    /**
     * Dernière page
     */
    @RequestMapping(params = "_finish")
    public ModelAndView processFinish(@ModelAttribute("modelWizard") String modelWizard, SessionStatus status) {
        // suppression de l'objet en session
        status.setComplete();
        return new ModelAndView("wizard/successView");
    }

    @RequestMapping(params = "_cancel")
    public String processCancel(SessionStatus status) {
        // suppression de l'objet en session
        status.setComplete();
        return "wizard/canceledView";
    }

}

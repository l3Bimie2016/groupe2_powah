package fr.assurance.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import fr.assurance.bean.ApplicationData;

@RestController
public class IndexController {

	@Autowired
	private ApplicationData appData;
	
	@RequestMapping(path = "/",method = RequestMethod.GET)
	public String indexView() {
		return appData.getToken();
	}
}

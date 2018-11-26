package ng.nectar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import ng.nectar.service.PoliticianService;

@Controller
public class ProfileController {

	@GetMapping("/politicians")
	public ModelAndView displayPoliticians() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("politicians", politicianService.getAll());
		modelAndView.setViewName("politicians");
		return modelAndView;
	}

	public ProfileController(PoliticianService politicianService) {
		this.politicianService = politicianService;
	}
	private PoliticianService politicianService;

}



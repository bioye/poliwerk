package ng.nectar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ng.nectar.model.FedConstituency;
import ng.nectar.model.LocalGovernment;
import ng.nectar.model.SenatorialDistrict;
import ng.nectar.model.State;
import ng.nectar.model.StateConstituency;
import ng.nectar.model.Ward;
import ng.nectar.service.PuService;
import ng.nectar.service.StateConstService;
import ng.nectar.service.WardService;

@Controller
public class ConstituenciesController {
	
	private WardService wardService;
	private PuService puService;
	StateConstService stateConstService;
	
	@Autowired
	public ConstituenciesController(PuService puService, WardService wardService) {
		this.wardService = wardService;
		this.puService = puService;
	}
	
	// Process confirmation link
	@RequestMapping(value="/pu", method = RequestMethod.GET)
	public ModelAndView displayPollingUnit(ModelAndView modelAndView, @RequestParam("id") String id) {
		//office name
		//current office holder
		//name
		//passport photo
			
		modelAndView.setViewName("pu");
		return modelAndView;		
	}

	@GetMapping("/ward/{id}")
	public ModelAndView ward(@PathVariable Integer id){
		Ward ward = wardService.getWard(id);
		ModelAndView modelAndView = new ModelAndView();
		if(null!=ward) {
			modelAndView.addObject("code", ward.getCode());
			modelAndView.addObject("name", ward.getName());
			LocalGovernment lg=ward.getLg();
			if(null!=lg) {
				modelAndView.addObject("lg", lg.getName());
				State state = lg.getState();
				if(null!=state) modelAndView.addObject("state", state.getName());
			}
			StateConstituency stateConst=ward.getStateConst();
			if(null!=stateConst) modelAndView.addObject("stateConst", stateConst.getName());
			FedConstituency fedConst=ward.getFedConst();
			if(null!=fedConst) modelAndView.addObject("fedConst", fedConst.getName());
			SenatorialDistrict senate=ward.getDistrict();
			if(null!=senate) modelAndView.addObject("district", senate.getName());
		}
		modelAndView.setViewName("ward");
		return modelAndView;
	}
	
	// Process confirmation link
	@GetMapping("/stateconst/{id}")
	public ModelAndView displayStateConst(@PathVariable Integer id){
		StateConstituency stateConst = stateConstService.getStateConst(id);
		ModelAndView modelAndView = new ModelAndView();
		if(null!=stateConst) {
			modelAndView.addObject("code", stateConst.getCode());
			modelAndView.addObject("name", stateConst.getName());
			//constituency
			//office
			//official
			
		}
		//state constituency
		//state constituency code
		//office name
		//current office holder
		//name
		//passport photo
			
		modelAndView.setViewName("pu");
		return modelAndView;		
	}

}

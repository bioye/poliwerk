package ng.nectar.controller;

import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nulabinc.zxcvbn.Strength;
import com.nulabinc.zxcvbn.Zxcvbn;

import ng.nectar.model.FedConstituency;
import ng.nectar.model.LocalGovernment;
import ng.nectar.model.PollingUnit;
import ng.nectar.model.SenatorialDistrict;
import ng.nectar.model.State;
import ng.nectar.model.StateConstituency;
import ng.nectar.model.User;
import ng.nectar.model.Ward;
import ng.nectar.service.EmailService;
import ng.nectar.service.PuService;
import ng.nectar.service.UserService;
import ng.nectar.service.WardService;

@Controller
public class UserController {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	private UserService userService;
	private EmailService emailService;
	private PuService puService;
	private WardService wardService;
	
	@Autowired
	public UserController(BCryptPasswordEncoder bCryptPasswordEncoder,
			UserService userService, EmailService emailService, PuService puService, WardService wardService) {
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
		this.userService = userService;
		this.emailService = emailService;
		this.puService = puService;
		this.wardService = wardService;
	}

	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("title", "Project Nectar - Login");
		modelAndView.setViewName("login");
		return modelAndView;
	}

	@RequestMapping(value="/location", method = RequestMethod.GET)
	public ModelAndView location(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("latLng", "");
		modelAndView.addObject("latitude", "");
		modelAndView.addObject("longitude", "");
		modelAndView.setViewName("location");
		return modelAndView;
	}

	@RequestMapping(value="/location", method = RequestMethod.POST)
	public ModelAndView processLocation(ModelAndView modelAndView, BindingResult bindingResult, HttpServletRequest request) {
		//extract coords
		//save to User.Location
		//find polling unit
		//display constituencies
		return modelAndView;
	}

	@RequestMapping(value="/puSpecify", method = RequestMethod.GET)
	public ModelAndView puSpecify(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		PollingUnit pu = user.getPu();
		if(null!=pu) modelAndView = helpPuSpecify(modelAndView, pu);
		//load pollingUnit
		//
		//modelAndView.addObject("pu", "");//
		modelAndView.addObject("puCode", "");
		modelAndView.setViewName("puSpecify");
		return modelAndView;
	}

	@RequestMapping(value="/puSpecify", method = RequestMethod.POST)
	public ModelAndView processPuSpecify(ModelAndView modelAndView, @RequestParam(required=false,name="puCode") String code){
		//load pollingUnit
		//PollingUnit pu = puService.findByCode(puService.puToCode(code));
		PollingUnit pu = puService.findByCode(puService.puToStoredCode(code));
		if(null!=pu) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = userService.findByEmail(auth.getName());
			user.setPu(pu);
			userService.saveUser(user);//
			modelAndView = helpPuSpecify(modelAndView, pu);
		}
		/*{
			modelAndView.addObject("code", code);
			modelAndView.addObject("puDesc", pu.getDescription());
			Ward ward = pu.getWard();
			if(null!=ward) {
				modelAndView.addObject("ward", ward.getName());
				modelAndView.addObject("wardId", ward.getId());
				StateConstituency stateConst=ward.getStateConst();
				if(null!=stateConst) modelAndView.addObject("stateConst", stateConst.getName());
				FedConstituency fedConst=ward.getFedConst();
				if(null!=fedConst) modelAndView.addObject("fedConst", fedConst.getName());
				SenatorialDistrict senate=ward.getDistrict();
				if(null!=senate) modelAndView.addObject("senatorial", senate.getName());
				LocalGovernment lg = ward.getLg();
				if(null!=lg) {
					modelAndView.addObject("lg", lg.getName());
					State state = lg.getState();
					if(null!=state) {
						modelAndView.addObject("state", state.getName());
					}
				}
			}
		}*/
		else {
			modelAndView.addObject("puNotExistsMessage", "The provided polling unit code["+ code+"] does not match any existing Polling Unit in the INEC Database.");
		}
		modelAndView.setViewName("/puSpecify");
		return modelAndView;
	}
	
	public ModelAndView helpPuSpecify(ModelAndView modelAndView, PollingUnit pu) {
		if(null!=pu) {
			modelAndView.addObject("code", pu.getPuLocation());
			modelAndView.addObject("puDesc", pu.getDescription());
			Ward ward = pu.getWard();
			if(null!=ward) {
				modelAndView.addObject("ward", ward.getName());
				modelAndView.addObject("wardId", ward.getId());
				StateConstituency stateConst=ward.getStateConst();
				if(null!=stateConst) modelAndView.addObject("stateConst", stateConst.getName());
				FedConstituency fedConst=ward.getFedConst();
				if(null!=fedConst) modelAndView.addObject("fedConst", fedConst.getName());
				SenatorialDistrict senate=ward.getDistrict();
				if(null!=senate) modelAndView.addObject("senatorial", senate.getName());
				LocalGovernment lg = ward.getLg();
				if(null!=lg) {
					modelAndView.addObject("lg", lg.getName());
					State state = lg.getState();
					if(null!=state) modelAndView.addObject("state", state.getName());
				}
			}
		}
		
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

	@RequestMapping(value="admin/location", method = RequestMethod.GET)
	public ModelAndView adminLocation(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin/location");
		return modelAndView;
	}
	
	// Return registration form template
	@RequestMapping(value="/register", method = RequestMethod.GET)
	public ModelAndView showRegistrationPage(ModelAndView modelAndView, User user){
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	// Process form input data
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView processRegistrationForm(ModelAndView modelAndView, @Valid User user, BindingResult bindingResult, HttpServletRequest request) {
				
		// Lookup user in database by e-mail
		User userExists = userService.findByEmail(user.getEmail());
		
		System.out.println(userExists);
		
		if (userExists != null) {
			modelAndView.addObject("alreadyRegisteredMessage", "Oops!  There is already a user registered with the email provided.");
			modelAndView.setViewName("register");
			bindingResult.reject("email");
		}
			
		if (bindingResult.hasErrors()) { 
			modelAndView.setViewName("register");		
		} else { // new user so we create user and send confirmation e-mail
					
			// Disable user until they click on confirmation link in email
		    user.setEnabled(false);
		      
		    // Generate random 36-character string token for confirmation link
		    user.setConfirmationToken(UUID.randomUUID().toString());
		        
		    userService.saveUser(user);
				
			String appUrl = request.getScheme() + "://" + request.getServerName()+":"+request.getServerPort();
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(user.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
					+ appUrl + "/confirm?token=" + user.getConfirmationToken());
			registrationEmail.setFrom("noreply@domain.com");
			
			emailService.sendEmail(registrationEmail);
			
			modelAndView.addObject("confirmationMessage", "A confirmation e-mail has been sent to " + user.getEmail());
			modelAndView.setViewName("register");
		}
			
		return modelAndView;
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
	
	// Process confirmation link
	@RequestMapping(value="/confirm", method = RequestMethod.GET)
	public ModelAndView confirmRegistration(ModelAndView modelAndView, @RequestParam("token") String token) {
			
		User user = userService.findByConfirmationToken(token);
			
		if (user == null) { // No token found in DB
			modelAndView.addObject("invalidToken", "Oops!  This is an invalid confirmation link.");
		} else { // Token found
			modelAndView.addObject("confirmationToken", user.getConfirmationToken());
		}
			
		modelAndView.setViewName("confirm");
		return modelAndView;		
	}
	
	// Process confirmation link
	@RequestMapping(value="/confirm", method = RequestMethod.POST)
	public ModelAndView confirmRegistration(ModelAndView modelAndView, BindingResult bindingResult, @RequestParam Map<String, String> requestParams, RedirectAttributes redir) {
				
		modelAndView.setViewName("confirm");
		
		Zxcvbn passwordCheck = new Zxcvbn();
		
		Strength strength = passwordCheck.measure(requestParams.get("password"));
		
		if (strength.getScore() < 3) {
			//modelAndView.addObject("errorMessage", "Your password is too weak.  Choose a stronger one.");
			bindingResult.reject("password");
			
			redir.addFlashAttribute("errorMessage", "Your password is too weak.  Choose a stronger one.");

			modelAndView.setViewName("redirect:confirm?token=" + requestParams.get("token"));
			System.out.println(requestParams.get("token"));
			return modelAndView;
		}
	
		// Find the user associated with the reset token
		User user = userService.findByConfirmationToken(requestParams.get("token"));

		// Set new password
		user.setPassword(bCryptPasswordEncoder.encode(requestParams.get("password")));

		// Set user to enabled
		user.setEnabled(true);
		
		// Save user
		userService.saveUser(user);
		
		modelAndView.addObject("successMessage", "Your password has been set!");
		return modelAndView;		
	}
	
	@RequestMapping(value="/admin/home", method = RequestMethod.GET)
	public ModelAndView home(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getFirstName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/home");
		return modelAndView;
	}	
	
}
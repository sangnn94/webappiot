package vn.edu.uit.iot.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.UserService;


@Controller
public class AuthenticateController {
	private static Logger logger = Logger.getLogger(AuthenticateController.class);

	@Autowired
	private UserService userService;

	/**
	 * Show login page
	 * 
	 * @return login.jsp
	 */
	@RequestMapping(value = "/login")
	public ModelAndView showLogin(ModelAndView modelAndView) {
		logger.info("LOGIN PAGE...");
		modelAndView.setViewName("login");
		return modelAndView;
	}

	/**
	 * Show new account form
	 * 
	 * @return register.jsp
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showNewAccount(ModelAndView modelAndView, @ModelAttribute("user") UserModel user) {
		logger.info("REGISTER PAGE...");
		modelAndView.setViewName("register");
		return modelAndView;
	}

	/**
	 * Handle create user
	 * 
	 * @return register.jsp
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView createUser(ModelAndView modelAndView, @Valid @ModelAttribute("user") UserModel user,
			BindingResult result) {
		modelAndView.setViewName("register");
		if (!result.hasErrors()) {
			userService.create(user);
			modelAndView.setViewName("redirect:/login");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/manage-user", method = RequestMethod.GET)
	public ModelAndView manageUser(ModelAndView modelAndView) {
		List<UserModel> users = userService.getAll();
		modelAndView.getModel().put("users", users);
		modelAndView.setViewName("manageuser");
		return modelAndView;
	}
	/**
	 * 403 access denied custom page
	 */
	@RequestMapping(value="/access-denied", method=RequestMethod.GET)
	public ModelAndView accessDenied(ModelAndView modelAndView){
		modelAndView.setViewName("accessdenied");
		return modelAndView;
		
	}
}

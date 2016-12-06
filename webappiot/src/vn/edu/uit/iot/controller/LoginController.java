package vn.edu.uit.iot.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.UserService;

@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private UserService userService;

	/**
	 * Show login page
	 * 
	 * @return login.jsp
	 */
	@RequestMapping("/login")
	public String showLogin() {
		logger.info("Showing login page....");
		return "login";
	}

	/**
	 * Show new account form
	 * 
	 * @return newaccout.jsp
	 */
	@RequestMapping(value = "/register", method = RequestMethod.GET)
	public ModelAndView showNewAccount(ModelAndView modelAndView, @ModelAttribute("user") UserModel user) {
		modelAndView.setViewName("register");
		return modelAndView;
	}

	/**
	 * Handle create user
	 * 
	 * @return index.jsp
	 */
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView createUser(ModelAndView modelAndView, @Valid @ModelAttribute("user") UserModel user,
			BindingResult result) {
		modelAndView.setViewName("register");
		if (!result.hasErrors()) {
			user.setPermission("ROLE_USER");
			userService.create(user);
			modelAndView.setViewName("redirect:/");
		}

		return modelAndView;
	}
	
}

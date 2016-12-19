package vn.edu.uit.iot.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.authentication.AuthenticationFacadeInterface;
import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.UserService;
import vn.edu.uit.iot.service.UserServiceImpl;

@Controller
public class AuthenticateController {
	private static Logger logger = Logger.getLogger(AuthenticateController.class);

	@Autowired
	private UserService userService;
	
	/*
	 * Show login page
	 * 
	 * @return login.jsp
	 */
	@RequestMapping(value="/login")
	public ModelAndView showLogin(ModelAndView modelAndView, @ModelAttribute(name = "user") UserModel user) {
		logger.info("Showing login page....");
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
		modelAndView.setViewName("/register");
		if (!result.hasErrors()) {
			user.setPermission("ROLE_USER");
			userService.create(user);
			modelAndView.setViewName("redirect:/");
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

}

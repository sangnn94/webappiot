package vn.edu.uit.iot.controller;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	@RequestMapping("/newaccount")
	public String showNewAccount(Model model) {
		model.addAttribute("user", new UserModel());
		return "newaccount";
	}

	/**
	 * Handle create user
	 * 
	 * @return index.jsp
	 */
	@RequestMapping(value = "/createaccount", method = RequestMethod.POST)
	public String showCreateUser(@Valid UserModel user, BindingResult result) {
		if (result.hasErrors()) {
			return "newaccount";
		}
		user.setPermission("ROLE_USER");
		userService.create(user);
		return "index";
	}
}

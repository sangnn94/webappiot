package vn.edu.uit.iot.controller;


import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.uit.iot.authentication.AuthenticationFacadeInterface;
import vn.edu.uit.iot.editor.LocationEditor;
import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.UserService;

@Controller
public class ManageController {

	@Autowired
	private LocationService locationService;

	@Autowired
	private UserService userService;

	@Autowired
	private GatewayService gatewayService;

	@Autowired
	private AuthenticationFacadeInterface authenticationFacade;

	private UserModel getCurrentUser() {
		Authentication auth = authenticationFacade.getAuthentication();
		String username = auth.getName();
		UserModel user = userService.get(username);
		return user;
	}

	@InitBinder
	protected void locationBinder(WebDataBinder binder) {
		binder.registerCustomEditor(LocationModel.class, new LocationEditor(locationService));
	}

	@RequestMapping(value = "/manage-device/add-device", method = RequestMethod.GET)
	public ModelAndView showNewGateway(ModelAndView mModelAndView, @ModelAttribute("gateway") GatewayModel gateway) {
		mModelAndView.setViewName("newgateway");
		List<LocationModel> listLocation = locationService.getAll();
		mModelAndView.getModel().put("locations", listLocation);
		return mModelAndView;
	}

	@RequestMapping(value = "/manage-device/add-device", method = RequestMethod.POST)
	public ModelAndView createGateway(ModelAndView mModelAndView,
			@Valid @ModelAttribute("gateway") GatewayModel gateway, BindingResult result,
			RedirectAttributes redirectAttribute) {
		if (result.hasErrors()) {
			mModelAndView.setViewName("redirect:/manage-device/add-device");
			redirectAttribute.addFlashAttribute("org.springframework.validation.BindingResult.gateway", result);
			redirectAttribute.addFlashAttribute("gateway", gateway);
		} else {
			System.out.println(gateway.getAddress());
			UserModel user = getCurrentUser();
			gateway.setUser(user);
			gateway.setLatitude((float) 10.825895);
			gateway.setLongitude((float) 106.628147);
			gatewayService.insert(gateway);
			mModelAndView.setViewName("redirect:/manage-device/");
		}
		return mModelAndView;
	}

	@RequestMapping(value = "/manage-user/add-user", method = RequestMethod.GET)
	public ModelAndView addUser(ModelAndView mModelAndView, Model model) {
		mModelAndView = new ModelAndView("newaccount");
		return mModelAndView;
	}
}

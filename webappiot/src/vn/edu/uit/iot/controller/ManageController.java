package vn.edu.uit.iot.controller;

import java.security.Principal;
import java.util.List;

import javax.tools.DocumentationTool.Location;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.LocaleEditor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.authentication.AuthenticationFacadeInterface;
import vn.edu.uit.iot.editor.LocationEditor;
import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.model.NodeModel;
import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.UserService;
import vn.edu.uit.iot.service.UserServiceImpl;

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
		mModelAndView.addObject("locations", listLocation);
		return mModelAndView;
	}

	@RequestMapping(value = "/manage-device/add-device", method = RequestMethod.POST)
	public ModelAndView createGateway(ModelAndView mModelAndView,
			@Valid @ModelAttribute("gateway") GatewayModel gateway) {
		mModelAndView.setViewName("newgateway");
		System.out.println(getCurrentUser().getEmail());
		System.out.println(getCurrentUser());
		System.out.println(gateway);
		//gatewayService.insert(gateway);
		return mModelAndView;
	}

	@RequestMapping(value = "/manage-user/add-user", method = RequestMethod.GET)
	public ModelAndView addUser(ModelAndView mModelAndView, Model model) {
		mModelAndView = new ModelAndView("newaccount");
		return mModelAndView;
	}
}

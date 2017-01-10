package vn.edu.uit.iot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import vn.edu.uit.iot.authentication.AuthenticationFacadeInterface;
import vn.edu.uit.iot.editor.LocationEditor;
import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.GpsJson;
import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.UserService;

@Controller
public class GatewayController {
	private static Logger logger = Logger.getLogger(AuthenticateController.class);

	@Autowired
	private GatewayService gatewayService;

	@Autowired
	private LocationService locationService;

	@Autowired
	private UserService userService;

	@Autowired
	private AuthenticationFacadeInterface authenticationFacade;

	@RequestMapping(value = "/gps", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> postGps(@RequestBody GpsJson gps) {
		logger.info(gps);
		String id = gps.getId();
		GatewayModel gateway = gatewayService.get(id);
		if (gateway == null) {
			// not found in database
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		String[] rawGps = gps.getGps().split(",");
		Float longitude = Float.parseFloat(rawGps[1]);
		Float latitude = Float.parseFloat(rawGps[2]);
		gateway.setLongitude(longitude);
		gateway.setLatitude(latitude);
		gatewayService.update(gateway);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

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

	@RequestMapping(value = "/new-gateway", method = RequestMethod.GET)
	public ModelAndView newGateway(ModelAndView mModelAndView, @ModelAttribute("gateway") GatewayModel gateway) {
		mModelAndView.setViewName("newgateway");
		List<LocationModel> listLocation = locationService.getAll();
		mModelAndView.getModel().put("locations", listLocation);
		return mModelAndView;
	}

	@RequestMapping(value = "/new-gateway", method = RequestMethod.POST)
	public ModelAndView createGateway(ModelAndView modelAndView, @Valid @ModelAttribute("gateway") GatewayModel gateway,
			BindingResult result, RedirectAttributes redirectAttribute) {
		if (result.hasErrors()) {
			modelAndView.setViewName("redirect:/new-gateway");
			redirectAttribute.addFlashAttribute("org.springframework.validation.BindingResult.gateway", result);
			redirectAttribute.addFlashAttribute("gateway", gateway);
		} else {
			UserModel user = getCurrentUser();
			gateway.setUser(user);
			gateway.setLatitude((float) 10.825895);
			gateway.setLongitude((float) 106.628147);
			gatewayService.insert(gateway);
			modelAndView.setViewName("redirect:/manage-device");
		}
		return modelAndView;
	}

	// Display list device
	@RequestMapping(value = "/manage-device", method = RequestMethod.GET)
	public ModelAndView getManageDevice(ModelAndView mModelAndView) {
		logger.info("Showing manage device page....");
		mModelAndView.setViewName("managedevice");
		UserModel user = getCurrentUser();
		Map<String, GatewayModel> gateways = user.getGateways();
		mModelAndView.getModel().put("gateways", gateways);
		return mModelAndView;
	}
}

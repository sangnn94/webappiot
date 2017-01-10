package vn.edu.uit.iot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.authentication.AuthenticationFacadeInterface;
import vn.edu.uit.iot.editor.GatewayEditor;
import vn.edu.uit.iot.editor.LocationEditor;
import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.model.NodeModel;
import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.NodeService;
import vn.edu.uit.iot.service.UserService;

@Controller
public class NodeController {
	@Autowired
	private GatewayService gatewayService;

	@Autowired
	private UserService userService;

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
		binder.registerCustomEditor(GatewayModel.class, new GatewayEditor(getCurrentUser()));
	}

	@RequestMapping(value = "/new-node", method = RequestMethod.GET)
	public ModelAndView newNode(ModelAndView modelAndView, @ModelAttribute("node") NodeModel node) {
		UserModel user = getCurrentUser();
		Map<String, GatewayModel> gateways = user.getGateways();
		modelAndView.getModel().put("gateways", gateways);
		modelAndView.setViewName("newnode");
		return modelAndView;
	}

	@RequestMapping(value = "/new-node", method = RequestMethod.POST)
	public ModelAndView createNode(ModelAndView modelAndView, @ModelAttribute("node") NodeModel node,
			BindingResult result) {
		if (result.hasErrors()) {
			modelAndView.setViewName("redirect:/new-node");
		} else {
			GatewayModel gateway = node.getGateway();
			gateway.getNodes().put(node.getId(), node);
			gatewayService.update(gateway);
			modelAndView.setViewName("redirect:/manage-device");
		}
		return modelAndView;
	}
}

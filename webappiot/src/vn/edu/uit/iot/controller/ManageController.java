package vn.edu.uit.iot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.NodeModel;



@Controller
public class ManageController {
	

	
	
	@RequestMapping(value="/manage-device/add-device" , method= RequestMethod.GET)
	public ModelAndView addDevice(ModelAndView mModelAndView,Model model){
		mModelAndView = new ModelAndView("newgateway");
//		model.addAttribute("add-gateway", new GatewayModel());
//		model.addAttribute("add-node", new NodeModel());
		return mModelAndView;
	}
	

	@RequestMapping(value="/manage-user/add-user" , method= RequestMethod.GET)
	public ModelAndView addUser(ModelAndView mModelAndView, Model model){
		mModelAndView = new ModelAndView("newaccount");
		return mModelAndView;
	}
}

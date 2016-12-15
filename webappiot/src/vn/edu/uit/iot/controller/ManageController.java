package vn.edu.uit.iot.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.model.NodeModel;
import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;



@Controller
public class ManageController {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private GatewayService gatewayService;
	
	
	@RequestMapping(value="/manage-device/add-device" , method= RequestMethod.GET)
	public ModelAndView showNewGateway(ModelAndView mModelAndView, @ModelAttribute("gateway") GatewayModel gateway){
		mModelAndView = new ModelAndView("newgateway");
		List<LocationModel> listLocation = locationService.getAll();
		mModelAndView.addObject("location", listLocation);
		return mModelAndView;
	}
	
	
	@RequestMapping(value="/manage-device/add-device", method= RequestMethod.POST)
	public ModelAndView createGateway(ModelAndView mModelAndView, @Valid @ModelAttribute("gateway") GatewayModel gateway){
		mModelAndView.setViewName("newgateway"); 
		System.out.println(gateway);
		//gatewayService.insert(gateway);
		return mModelAndView;
	}

	@RequestMapping(value="/manage-user/add-user" , method= RequestMethod.GET)
	public ModelAndView addUser(ModelAndView mModelAndView, Model model){
		mModelAndView = new ModelAndView("newaccount");
		return mModelAndView;
	}
}

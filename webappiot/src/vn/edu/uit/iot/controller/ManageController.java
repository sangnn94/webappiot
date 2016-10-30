package vn.edu.uit.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.NodeModel;

import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.NodeService;


@Controller
public class ManageController {
	
	@Autowired
	private LocationService mLocationService;
	
	@Autowired
	private NodeService mNodeService;
	
	@Autowired
	private GatewayService mGatewayService;
	
	
	@RequestMapping(value="/manage-device/add-device" , method= RequestMethod.GET)
	public ModelAndView addDevice(ModelAndView mModelAndView,Model model){
		mModelAndView = new ModelAndView("newdevice");
		model.addAttribute("add-node", new NodeModel());
		return mModelAndView;
	}
	

	@RequestMapping(value="/manage-user/add-user" , method= RequestMethod.GET)
	public ModelAndView addUser(ModelAndView mModelAndView, Model model){
		mModelAndView = new ModelAndView("newuser");
		return mModelAndView;
	}
}

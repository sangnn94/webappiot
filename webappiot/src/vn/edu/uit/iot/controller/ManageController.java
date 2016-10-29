package vn.edu.uit.iot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ManageController {
	@RequestMapping(value="/manage-device/add-device" , method= RequestMethod.GET)
	public ModelAndView addDevice(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("newdevice");
		return mModelAndView;
	}
	@RequestMapping(value="/manage-user/add-user" , method= RequestMethod.GET)
	public ModelAndView addUser(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("newuser");
		return mModelAndView;
	}
}

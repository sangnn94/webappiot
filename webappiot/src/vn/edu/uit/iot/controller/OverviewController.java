package vn.edu.uit.iot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class OverviewController {


	
	@RequestMapping(value="/overview/maps", method = RequestMethod.GET)
	public ModelAndView getMaps(ModelAndView mModelAndView, ModelMap mModelMap){
		mModelAndView = new ModelAndView("maps");
		return mModelAndView;
	}
}

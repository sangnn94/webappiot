package vn.edu.uit.iot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.service.DataService;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.NodeService;
import vn.edu.uit.iot.service.RecordService;

@Controller
public class HomeController {
	@Autowired
	private LocationService mLocationService;
	
	@Autowired
	private DataService mDataservice;
	
	@Autowired
	private NodeService mNodeService;
	
	@Autowired
	private GatewayService mGatewayService;
	
	@Autowired
	private RecordService mRecordService;
	
	
	@RequestMapping(value="/" , method= RequestMethod.GET)
	public ModelAndView home(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("index");
		System.out.println("location "+this.mLocationService.getAll().size());
		System.out.println("data "+this.mDataservice.getAll().size());
		System.out.println("node "+this.mNodeService.getAll().size());
		System.out.println("gateway "+this.mGatewayService.getAll().size());
		System.out.println("record "+this.mRecordService.getAll().size());
		return mModelAndView;
	}

}

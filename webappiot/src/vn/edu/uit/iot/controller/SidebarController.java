package vn.edu.uit.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.NodeModel;
import vn.edu.uit.iot.service.DataService;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.NodeService;
import vn.edu.uit.iot.service.RecordService;

@Controller
public class SidebarController {
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
	public ModelAndView getHome(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("index");
		System.out.println("location "+this.mLocationService.getAll().size());
		System.out.println("data "+this.mDataservice.getAll().size());
		System.out.println("node "+this.mNodeService.getAll().size());
		System.out.println("gateway "+this.mGatewayService.getAll().size());
		System.out.println("record "+this.mRecordService.getAll().size());
		return mModelAndView;
	}
	
	//Display list device 
	@RequestMapping(value="/manage-device" , method= RequestMethod.GET)
	public ModelAndView getManageDevice(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("managedevice");
		List<GatewayModel> arrGateway = mGatewayService.getAll();
		mModelAndView.addObject("listGateway", arrGateway);
		List<NodeModel> arrNode = mNodeService.getAll();
		mModelAndView.addObject("listNode", arrNode);
		return mModelAndView;
	}
	
	//Display list user
	@RequestMapping(value="/manage-user" , method= RequestMethod.GET)
	public ModelAndView getManageUser(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("manageuser");
		return mModelAndView;
	}
	
	@RequestMapping(value="/about" , method= RequestMethod.GET)
	public ModelAndView getAbout(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("about");
		return mModelAndView;
	}
	
	@RequestMapping(value="/report" , method= RequestMethod.GET)
	public ModelAndView getReport(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("report");
		return mModelAndView;
	}

}

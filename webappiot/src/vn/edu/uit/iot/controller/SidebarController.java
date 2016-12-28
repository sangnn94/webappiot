package vn.edu.uit.iot.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.authentication.AuthenticationFacadeInterface;
import vn.edu.uit.iot.model.AirModel;
import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.model.NodeModel;
import vn.edu.uit.iot.model.RecordModel;
import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.AirService;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.NodeService;
import vn.edu.uit.iot.service.RecordService;
import vn.edu.uit.iot.service.UserService;
import vn.edu.uit.iot.utils.Const;
import vn.edu.uit.iot.utils.HandleData;

@Controller
public class SidebarController {
	private static Logger logger = Logger.getLogger(AuthenticateController.class);

	@Autowired
	private NodeService mNodeService;
	
	@Autowired
	private GatewayService mGatewayService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RecordService mRecordService;
	
	@Autowired
	private AuthenticationFacadeInterface authenticationFacade;

	private UserModel getCurrentUser() {
		Authentication auth = authenticationFacade.getAuthentication();
		String username = auth.getName();
		UserModel user = userService.get(username);
		return user;
	}
	
	@RequestMapping(value="/" , method= RequestMethod.GET)
	public ModelAndView getHome(ModelAndView modelAndView){
		logger.info("Showing index page....");
		modelAndView.setViewName("index");		
		List<RecordModel> records = mRecordService.getAll();
		modelAndView.getModel().put("records", records);
		return modelAndView;
	}
	
	//Display list device 
	@RequestMapping(value="/manage-device" , method= RequestMethod.GET)
	public ModelAndView getManageDevice(ModelAndView mModelAndView){
		mModelAndView.setViewName("managedevice");
		UserModel user = getCurrentUser();
		Set<GatewayModel> gateways  = user.getGateways();
		mModelAndView.getModel().put("gateways" , gateways);
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

package vn.edu.uit.iot.controller;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.authentication.AuthenticationFacadeInterface;
import vn.edu.uit.iot.model.AirModel;
import vn.edu.uit.iot.model.GatewayModel;
import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.model.RecordModel;
import vn.edu.uit.iot.model.UserModel;
import vn.edu.uit.iot.service.AirService;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.NodeService;
import vn.edu.uit.iot.service.RecordService;
import vn.edu.uit.iot.service.UserService;

@Controller
public class SidebarController {
	private static Logger logger = Logger.getLogger(AuthenticateController.class);

	@Autowired
	private RecordService mRecordService;

	@Autowired
	private AirService mAirService;

	@Autowired
	private LocationService mLocationService;


	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getHome(ModelAndView modelAndView) {
		logger.info("Showing index page....");
		List<AirModel> airs = mAirService.getAll();
		List<LocationModel> locations = mLocationService.getAll();
		List<RecordModel> records = mRecordService.getLastest();
		modelAndView.getModel().put("records", records);
		modelAndView.getModel().put("airs", airs);
		modelAndView.getModel().put("locations", locations);
		modelAndView.setViewName("index");
		return modelAndView;
	}


	@RequestMapping(value = "/about", method = RequestMethod.GET)
	public ModelAndView getAbout(ModelAndView mModelAndView) {
		logger.info("Showing about page....");
		mModelAndView = new ModelAndView("about");
		return mModelAndView;
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public ModelAndView getReport(ModelAndView mModelAndView) {
		logger.info("Showing report page....");
		mModelAndView.setViewName("report");
		List<AirModel> airs = mAirService.getAll();
		List<LocationModel> locations = mLocationService.getAll();
		List<RecordModel> records = mRecordService.getLastest();
		mModelAndView.addObject("airs", airs);
		mModelAndView.addObject("locations", locations);
		mModelAndView.addObject("records", records);
		return mModelAndView;
	}

	@RequestMapping(value = "/report/view", method = RequestMethod.GET)
	public ModelAndView viewRecort(ModelAndView mModelAndView,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("from") Date fromDate,
			@DateTimeFormat(pattern = "yyyy-MM-dd") @RequestParam("to") Date toDate) {
		logger.info("Show records....");
		mModelAndView.setViewName("report");
		List<RecordModel> records = mRecordService.getForDate(fromDate, toDate);
		List<AirModel> airs = mAirService.getAll();
		List<LocationModel> locations = mLocationService.getAll();
		mModelAndView.addObject("records", records);
		mModelAndView.addObject("airs", airs);
		mModelAndView.addObject("locations", locations);
		return mModelAndView;
	}
}

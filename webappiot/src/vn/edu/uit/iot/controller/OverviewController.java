package vn.edu.uit.iot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.model.RecordModel;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.RecordService;
import vn.edu.uit.iot.utils.Const;
import vn.edu.uit.iot.utils.HandleData;


@Controller
public class OverviewController {
	@Autowired
	private RecordService mRecordService;
	
	@Autowired
	private GatewayService mGatewayService;
	
	@RequestMapping(value="/overview/maps", method = RequestMethod.GET)
	public ModelAndView getMaps(ModelAndView mModelAndView, ModelMap mModelMap){
		mModelAndView = new ModelAndView("maps");
		return mModelAndView;
	}
	
	@RequestMapping(value = "/overview/chart", method = RequestMethod.GET)
	public ModelAndView getChart(ModelAndView mModelAndView, ModelMap mModelMap) {
		mModelAndView = new ModelAndView("chart");
		List<RecordModel> listRecord = mRecordService.getAll();
		
		String coData = HandleData.getJson(Const.CO, listRecord);
		mModelAndView.addObject("CO", coData);
		String so2Data = HandleData.getJson(Const.SO2, listRecord);
		mModelAndView.addObject("SO2", so2Data);
		String o3Data = HandleData.getJson(Const.O3, listRecord);
		mModelAndView.addObject("O3", o3Data);
		String pbData = HandleData.getJson(Const.Pb, listRecord);
		mModelAndView.addObject("Pb", pbData);
		String tspData = HandleData.getJson(Const.TSP, listRecord);
		mModelAndView.addObject("TSP", tspData);
		String pm10Data = HandleData.getJson(Const.PM10, listRecord);
		mModelAndView.addObject("PM10", pm10Data);
		String pm25Data = HandleData.getJson(Const.PM25, listRecord);
		mModelAndView.addObject("PM25", pm25Data);
		
		return mModelAndView;
	}
	
	@RequestMapping(value="/overview/airstandard", method = RequestMethod.GET)
	public ModelAndView getAirStandard(ModelAndView mModelAndView, ModelMap mModelMap){
		mModelAndView = new ModelAndView("airstandard");
		return mModelAndView;
	}
}



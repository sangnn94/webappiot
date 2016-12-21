package vn.edu.uit.iot.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.model.AirModel;
import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.model.RecordModel;
import vn.edu.uit.iot.service.AirService;
import vn.edu.uit.iot.service.GatewayService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.RecordService;
import vn.edu.uit.iot.utils.Const;
import vn.edu.uit.iot.utils.HandleData;


@Controller
public class OverviewController {
	@Autowired
	private RecordService mRecordService;
	
	@Autowired
	private GatewayService mGatewayService;
	
	@Autowired
	private LocationService mLocationService;
	
	@Autowired
	private AirService mAirService;
	
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
	
	@RequestMapping(value="/random-data", method=RequestMethod.POST )
	public ModelAndView radomData(ModelAndView mModelAndView){
		mModelAndView.setViewName("index");
		List<LocationModel> listLocation = mLocationService.getAll();
		List<AirModel> listAir = mAirService.getAll();
		

		for (int i = 0; i < listLocation.size(); i++) {
			for (int j = 0; j < listAir.size(); j++) {
			
					RecordModel record = new RecordModel();
					record.setLocation(listLocation.get(i));
					record.setDate(new Date());
					record.setAir(listAir.get(j));
					switch (listAir.get(j).getId()) {
					case Const.CO:
						record.setValue(HandleData.randomData(10000, 40000));
						if (record.getValue() > 30000)
							record.setEvaluation("HIGH");
						else
							record.setEvaluation("");
						break;
					case Const.SO2:
						record.setValue(HandleData.randomData(100, 500));
						if (record.getValue() > 350)
							record.setEvaluation("HIGH");
						else
							record.setEvaluation("");
						break;
					case Const.NO2:
						record.setValue(HandleData.randomData(50, 300));
						if (record.getValue() > 200)
							record.setEvaluation("HIGH");
						else
							record.setEvaluation("");
						break;
					case Const.O3:
						record.setValue(HandleData.randomData(100, 300));
						if (record.getValue() > 200)
							record.setEvaluation("HIGH");
						else
							record.setEvaluation("");
						break;
					case Const.Pb:
						record.setValue(HandleData.randomData(1, 4));
						if (record.getValue() > 300)
							record.setEvaluation("HIGH");
						else
							record.setEvaluation("");
						break;
					case Const.PM10:
						record.setValue(HandleData.randomData(50, 200));
						if (record.getValue() > 300)
							record.setEvaluation("HIGH");
						else
							record.setEvaluation("");
						break;
					case Const.PM25:
						record.setValue(HandleData.randomData(10, 100));
						if (record.getValue() > 300)
							record.setEvaluation("HIGH");
						else
							record.setEvaluation("");
						break;
					case Const.TSP:
						record.setValue(HandleData.randomData(100, 400));
						if (record.getValue() > 300)
							record.setEvaluation("HIGH");
						else
							record.setEvaluation("");
						break;
					}
					record.setTimeStandard(Const.TIME_STANDARD_ONE_HOUR);
					mRecordService.insert(record);

			}
		}
		return mModelAndView;
	}
	
	
}



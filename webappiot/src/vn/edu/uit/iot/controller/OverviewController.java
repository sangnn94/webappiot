package vn.edu.uit.iot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import vn.edu.uit.iot.model.AirModel;
import vn.edu.uit.iot.model.GatewayModel;
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
	public ModelAndView getMaps(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("maps");
		List<GatewayModel> gatewayModel = mGatewayService.getAll();
		mModelAndView.addObject("gateway", gatewayModel);
		List<String> address = new ArrayList<>();
		for (GatewayModel gateway : gatewayModel) {
			System.out.println("hai");
			address.add(gateway.getAddress());
		}
		mModelAndView.addObject("address", address);
		return mModelAndView;
	}
	
	@RequestMapping(value = "/overview/chart", method = RequestMethod.GET)
	public ModelAndView getChart(ModelAndView mModelAndView, ModelMap mModelMap) {
		mModelAndView = new ModelAndView("chart");
		List<RecordModel> listRecord = mRecordService.getLastest();
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
		String noData = HandleData.getJson(Const.NO2, listRecord);
		mModelAndView.addObject("NO", noData);
		
		return mModelAndView;
	}
	
	@RequestMapping(value="/overview/airstandard", method = RequestMethod.GET)
	public ModelAndView getAirStandard(ModelAndView mModelAndView){
		mModelAndView = new ModelAndView("airstandard");
		return mModelAndView;
	}
	
	@RequestMapping(value="/random-data", method=RequestMethod.POST )
	public ModelAndView radomData(ModelAndView mModelAndView){
		mModelAndView.setViewName("redirect:/");
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
							record.setEvaluation("Danger");
						else if (record.getValue() < 30000 && record.getValue() > 27000)
							record.setEvaluation("Warning");
						else
							record.setEvaluation("Normal");
						break;
					case Const.SO2:
						record.setValue(HandleData.randomData(100, 400));
						if (record.getValue() > 350)
							record.setEvaluation("Danger");
						else if (record.getValue() < 350 && record.getValue() > 315)
							record.setEvaluation("Warning");
						else
							record.setEvaluation("Normal");
						break;
					case Const.NO2:
						record.setValue(HandleData.randomData(100, 300));
						if (record.getValue() > 200)
							record.setEvaluation("Danger");
						else if (record.getValue() < 200 && record.getValue() > 180)
							record.setEvaluation("Warning");
						else
							record.setEvaluation("Normal");
						break;
					case Const.O3:
						record.setValue(HandleData.randomData(100, 300));
						if (record.getValue() > 200)
							record.setEvaluation("Danger");
						else if (record.getValue() < 200 && record.getValue() > 180)
							record.setEvaluation("Warning");
						else
							record.setEvaluation("Normal");
						break;
					case Const.Pb:
						record.setValue(HandleData.randomData(1, 4));
						if (record.getValue() > 1.5)
							record.setEvaluation("Danger");
						else if (record.getValue() < 1.5 && record.getValue() > 1.35)
							record.setEvaluation("Warning");
						else
							record.setEvaluation("Normal");
						break;
					case Const.PM10:
						record.setValue(HandleData.randomData(50, 200));
						if (record.getValue() > 150)
							record.setEvaluation("Danger");
						else if (record.getValue() < 150 && record.getValue() > 135)
							record.setEvaluation("Warning");
						else
							record.setEvaluation("Normal");
						break;
					case Const.PM25:
						record.setValue(HandleData.randomData(10, 70));
						if (record.getValue() > 50)
							record.setEvaluation("Danger");
						else if (record.getValue() < 50 && record.getValue() > 45)
							record.setEvaluation("Warning");
						else
							record.setEvaluation("Normal");
						break;
					case Const.TSP:
						record.setValue(HandleData.randomData(100, 300));
						if (record.getValue() > 200)
							record.setEvaluation("Danger");
						else if (record.getValue() < 200 && record.getValue() > 180)
							record.setEvaluation("Warning");
						else
							record.setEvaluation("Normal");
						break;
					}
					record.setTimeStandard(Const.TIME_STANDARD_ONE_HOUR);
					mRecordService.insert(record);
			}
		}
		return mModelAndView;
	}
	
	
}



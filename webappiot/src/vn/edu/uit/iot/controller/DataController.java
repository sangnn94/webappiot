package vn.edu.uit.iot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import vn.edu.uit.iot.model.AirModel;
import vn.edu.uit.iot.model.DataJson;
import vn.edu.uit.iot.model.DataModel;
import vn.edu.uit.iot.model.LocationModel;
import vn.edu.uit.iot.model.NodeModel;
import vn.edu.uit.iot.model.RecordModel;
import vn.edu.uit.iot.model.Value;
import vn.edu.uit.iot.model.ValueModel;
import vn.edu.uit.iot.service.AirService;
import vn.edu.uit.iot.service.DataService;
import vn.edu.uit.iot.service.LocationService;
import vn.edu.uit.iot.service.NodeService;
import vn.edu.uit.iot.service.RecordService;
import vn.edu.uit.iot.utils.Const;
import vn.edu.uit.iot.utils.Const.Times;
import vn.edu.uit.iot.utils.SingletonCurrentTimes;
import vn.edu.uit.iot.utils.TimeCompare;

@Controller
public class DataController {
	@Autowired
	private NodeService nodeService;
	@Autowired
	private AirService airService;
	@Autowired
	private DataService dataService;
	@Autowired
	private RecordService recordService;
	
	@Autowired
	private LocationService locationService;

	@RequestMapping(value = "/data", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> postData(@RequestBody DataJson data) {
		String id = data.getId();
		NodeModel node = nodeService.get(id);
		if (node == null) {
			// not found node in database
			return new ResponseEntity<Void>(HttpStatus.UNAUTHORIZED);
		}
		DataModel dataModel = new DataModel(node); // get data relation with a node
		Set<Value> values = data.getDatas();
		Set<ValueModel> valueModels = new HashSet<>();
		for (Value value : values) {
			AirModel air = airService.getData(value.getId());
			if (air == null) {
				continue;
			}
			ValueModel valueModel = new ValueModel(air, value.getValue());
			valueModel.setData(dataModel); // set parent of data to value
			valueModels.add(valueModel); // add to set of value
		}
		dataModel.setValue(valueModels); // add set to data record
		dataService.insert(dataModel);
		updateRecord();
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	private void updateRecord(){
		if(TimeCompare.oneHour()){
			Date date = new Date();
			SingletonCurrentTimes.getInstance().setOneHour(date);
			List<DataModel> listDataSelect = new ArrayList<>();
			List<DataModel> listData = dataService.getAll();
			for(int i=0; i<listData.size();i++){
				long time = SingletonCurrentTimes.getInstance().getOneHour().getTime()-listData.get(i).getDate().getTime();
				if (time < Const.Times.ONE_HOUR) {
					listDataSelect.add(listData.get(i));
				}
			}
			
			List<LocationModel> listLocation = locationService.getAll();
			for(int l=0; l<listLocation.size(); l++){
				List<DataModel> listDataLocation = getListDataLoation(listDataSelect, listLocation.get(l).getLocationId());
				if(listDataLocation.size()>0){
					inserNewRecord(listDataLocation, date, listLocation.get(l), Const.TIME_STANDARD_ONE_HOUR);
				}
			}
		}
		if(TimeCompare.eightHour()){
			Date date = new Date();
			SingletonCurrentTimes.getInstance().setEightHour(date);
			List<DataModel> listDataSelect = new ArrayList<>();
			List<DataModel> listData = dataService.getAll();
			for(int i=0; i<listData.size();i++){
				long time = SingletonCurrentTimes.getInstance().getEightHour().getTime()-listData.get(i).getDate().getTime();
				if (time < Const.Times.EIGHT_HOUR) {
					listDataSelect.add(listData.get(i));
				}
			}
			
			List<LocationModel> listLocation = locationService.getAll();
			for(int l=0; l<listLocation.size(); l++){
				List<DataModel> listDataLocation = getListDataLoation(listDataSelect, listLocation.get(l).getLocationId());
				if(listDataLocation.size()>0){
					inserNewRecord(listDataLocation, date, listLocation.get(l), Const.TIME_STANDARD_EIGHT_HOUR);
				}
			}
			
		}
		if(TimeCompare.oneDay()){
			Date date = new Date();
			SingletonCurrentTimes.getInstance().setOneday(date);
			List<DataModel> listDataSelect = new ArrayList<>();
			List<DataModel> listData = dataService.getAll();
			for(int i=0; i<listData.size();i++){
				long time = SingletonCurrentTimes.getInstance().getOneday().getTime()-listData.get(i).getDate().getTime();
				if (time < Const.Times.ONE_DAY) {
					listDataSelect.add(listData.get(i));
				}
			}
			
			List<LocationModel> listLocation = locationService.getAll();
			for(int l=0; l<listLocation.size(); l++){
				List<DataModel> listDataLocation = getListDataLoation(listDataSelect, listLocation.get(l).getLocationId());
				if(listDataLocation.size()>0){
					inserNewRecord(listDataLocation, date, listLocation.get(l), Const.TIME_STANDARD_ONE_DAY);
				}
			}
		}
			
	}
	
	private List<DataModel> getListDataLoation(List<DataModel> list , int locationID){
		List<DataModel> listData = new ArrayList<>();
		for(int i=0; i<list.size();i++){
			if(list.get(i).getNode().getGateway().getLocation().getLocationId() == locationID)
				listData.add(list.get(i));
		}
		return listData;
	}
	
	private void inserNewRecord(List<DataModel> listData,Date date, LocationModel location, int time){
		float valueCO = 0,valueSo2 = 0,valueO3 = 0,valuePb = 0,valueNo2 = 0,valueTsp = 0,valuePm10 = 0,valuePm25 = 0;
		for(int i=0 ; i<listData.size(); i++){
			for(ValueModel value : listData.get(i).getValue()){
				if(value.getAir().getId()==Const.CO)
					valueCO += (value.getValue()/listData.size());
				if(value.getAir().getId()==Const.SO2)
					valueSo2 += (value.getValue()/listData.size());
				if(value.getAir().getId()==Const.O3)
					valueO3 += (value.getValue()/listData.size());
				if(value.getAir().getId()==Const.Pb)
					valuePb += (value.getValue()/listData.size());
				if(value.getAir().getId()==Const.PM10)
					valuePm10 += (value.getValue()/listData.size());
				if(value.getAir().getId()==Const.PM25)
					valuePm25 += (value.getValue()/listData.size());
				if(value.getAir().getId()==Const.TSP)
					valueTsp += (value.getValue()/listData.size());
				if(value.getAir().getId()==Const.NO2)
					valueNo2 += (value.getValue()/listData.size());
			}
		}
		
		if(valueCO!=0){
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAirId(airService.getData(Const.CO));
			record.setValue(valueCO);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueCO>=30000)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				if(valueCO>=10000)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				record.setEvaluation("");
				break;
			}
			
		}
		
		if(valueSo2!=0){
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAirId(airService.getData(Const.CO));
			record.setValue(valueSo2);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueCO>=350)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				if(valueCO>=125)
				record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				record.setEvaluation("");
				break;
			}
			
		}
		
		if(valueO3!=0){
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAirId(airService.getData(Const.CO));
			record.setValue(valueCO);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueCO>=200)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				if(valueCO>=120)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				record.setEvaluation("");
				break;
			}
			recordService.insert(record);
		}
		if(valuePb!=0){
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAirId(airService.getData(Const.CO));
			record.setValue(valueCO);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				if(valueCO>=1.5)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valueCO>=0.5)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			}
			recordService.insert(record);
		}
		
		if(valueNo2!=0){
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAirId(airService.getData(Const.CO));
			record.setValue(valueNo2);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueCO>=200)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				if(valueCO>=100)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valueCO>=40)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			}
			recordService.insert(record);
		}
		if(valueTsp!=0){
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAirId(airService.getData(Const.CO));
			record.setValue(valueTsp);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueCO>=300)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				if(valueCO>=200)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valueCO>=100)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			}
			recordService.insert(record);
		}
		
		if(valuePm10!=0){
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAirId(airService.getData(Const.CO));
			record.setValue(valuePm10);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				if(valueCO>=150)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valueCO>=50)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			}
			recordService.insert(record);
		}
		if(valuePm25!=0){
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAirId(airService.getData(Const.CO));
			record.setValue(valuePm25);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				if(valueCO>=50)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valueCO>=25)
					record.setEvaluation("HIGH");
				else
					record.setEvaluation("");
				break;
			}
			recordService.insert(record);
		}
		
		
	}
}

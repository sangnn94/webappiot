package vn.edu.uit.iot.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
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
	
	private static Logger logger = Logger.getLogger(AuthenticateController.class);
	
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Void> postData(@RequestBody DataJson data) {
		logger.info(data);
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
		System.out.println(dataModel);
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
		int countCO = 0,countTsp = 0,countSo2 = 0,countO3 = 0,countPb = 0,countNo = 0,countPm10 = 0,countPm25 = 0;
		for(int i=0 ; i<listData.size(); i++){
			Set<ValueModel> values = listData.get(i).getValue();
			
			for(ValueModel value : values){
				if(value.getAir().getId()==Const.CO){
					valueCO += value.getValue();
					countCO++;
				}
				if(value.getAir().getId()==Const.SO2){
					valueSo2 += value.getValue();
					countSo2++;
				}
				if(value.getAir().getId()==Const.O3){
					valueO3 += value.getValue();
					countO3++;
				}
				if(value.getAir().getId()==Const.Pb){
					valuePb += value.getValue();
					countPb++;
				}
				if(value.getAir().getId()==Const.PM10){
					valuePm10 += value.getValue();
					countPm10++;
				}
				if(value.getAir().getId()==Const.PM25){
					valuePm25 += value.getValue();
					countPm25++;
				}
				if(value.getAir().getId()==Const.TSP){
					valueTsp += value.getValue();
					countTsp++;
				}
				if(value.getAir().getId()==Const.NO2){
					valueNo2 += value.getValue();
					countNo++;
				}
			}
		}
		
		if(valueCO!=0){
			valueCO = valueCO/countCO;
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAir(airService.getData(Const.CO));
			record.setValue(valueCO);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueCO>=30000)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueCO<30000 && valueCO > 27000)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				if(valueCO>=10000)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueCO<10000 && valueCO > 9000)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			default:
				record.setEvaluation("NA");
				break;
			}
			recordService.insert(record);
			
		}
		
		if(valueSo2!=0){
			valueSo2 = valueSo2/countSo2;
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAir(airService.getData(Const.SO2));
			record.setValue(valueSo2);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueSo2>=350)
					record.setEvaluation(Const.Evaluation.DANGER );
				else if(valueSo2<350 && valueSo2 > 315)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				if(valueSo2>=125)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueSo2<125 && valueSo2 > 113)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
			default:
				record.setEvaluation("NA");
				break;
			}
			recordService.insert(record);
			
		}
		
		if(valueO3!=0){
			valueO3 = valueO3/countO3;
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAir(airService.getData(Const.O3));
			record.setValue(valueCO);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueO3>=200)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueO3<200 && valueO3 > 180)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				if(valueCO>=120)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueO3<120 && valueO3 > 113)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			default:
				record.setEvaluation("NA");
				break;
			}
			recordService.insert(record);
		}
		if(valuePb!=0){
			valuePb = valuePb/countPb;
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAir(airService.getData(Const.Pb));
			record.setValue(valueCO);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_DAY:
				if(valuePb>=1.5)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valuePb<1.5 && valuePb > 1.35)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valuePb>=0.5)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valuePb<0.5 && valuePb > 0.45)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			default:
				record.setEvaluation("NA");
				break;
			}
			recordService.insert(record);
		}
		
		if(valueNo2!=0){
			valueNo2 = valueNo2/countNo;
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAir(airService.getData(Const.NO2));
			record.setValue(valueNo2);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueNo2>=200)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueNo2<200 && valueNo2 > 180)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_ONE_DAY:
				if(valueNo2>=100)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueNo2<100 && valueNo2 > 90)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valueNo2>=40)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueNo2<40 && valueNo2 > 36)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			default:
				record.setEvaluation("NA");
				break;
			}
			recordService.insert(record);
		}
		if(valueTsp!=0){
			valueTsp = valueTsp/countTsp;
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAir(airService.getData(Const.TSP));
			record.setValue(valueTsp);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_HOUR:
				if(valueTsp>=300)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueTsp<300 && valueTsp > 270)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_EIGHT_HOUR:
				if(valueTsp>=200)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueTsp<200 && valueTsp > 180)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valueTsp>=100)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valueTsp<100 && valueTsp > 90)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			default:
				record.setEvaluation("NA");
				break;
			}
			recordService.insert(record);
		}
		
		if(valuePm10!=0){
			valuePm10 = valuePm10/countPm10;
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAir(airService.getData(Const.PM10));
			record.setValue(valuePm10);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			case Const.TIME_STANDARD_ONE_DAY:
				if(valuePm10>=150)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valuePm10<150 && valuePm10 > 135)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valuePm10>=50)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valuePm10<50 && valuePm10 > 45)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			default:
				record.setEvaluation("NA");
				break;
			}
			recordService.insert(record);
		}
		if(valuePm25!=0){
			valuePm25 = valuePm25/countPm25;
			RecordModel record = new RecordModel();
			record.setDate(date);
			record.setAir(airService.getData(Const.PM25));
			record.setValue(valuePm25);
			record.setLocation(location);
			record.setTimeStandard(time);
			switch(time){
			
			case Const.TIME_STANDARD_ONE_DAY:
				if(valuePm25>=50)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valuePm25<50 && valuePm25 > 45)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			case Const.TIME_STANDARD_ONE_YEAR:
				if(valuePm25>=25)
					record.setEvaluation(Const.Evaluation.DANGER);
				else if(valuePm25<50 && valuePm25 > 45)
					record.setEvaluation(Const.Evaluation.WARNING);
				else
					record.setEvaluation(Const.Evaluation.NORMAL);
				break;
			default:
				record.setEvaluation("NA");
				break;
			}
			recordService.insert(record);
		}
		
		
	}
}

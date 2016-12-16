package vn.edu.uit.iot.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;

import vn.edu.uit.iot.model.RecordModel;

public class HandleData {


	private static List<AirData> getList(int air, List<RecordModel> listRecord){
		List<AirData> listAirData = new ArrayList<>();
		AirData airData;
		for(int i = 0; i<listRecord.size(); i++){
			airData =  new AirData();
			airData.setLocation(listRecord.get(i).getLocation().getLocationName());
			switch(air){
			case Const.CO:
					airData.setValue(listRecord.get(i).getValue());
					if(listRecord.get(i).getValue() > 30000)
						airData.setEvaluation("HIGH");
					break;
			case Const.SO2:
					airData.setValue(listRecord.get(i).getValue());
					if(listRecord.get(i).getValue() > 350)
						airData.setEvaluation("HIGH");
					break;
			case Const.O3:
					airData.setValue(listRecord.get(i).getValue());
					if(listRecord.get(i).getValue() > 200)
						airData.setEvaluation("HIGH");
					break;
			case Const.Pb:
					airData.setValue(listRecord.get(i).getValue());
					if(listRecord.get(i).getValue() > 1.5)
						airData.setEvaluation("HIGH");
					break;
			case Const.TSP:
					airData.setValue(listRecord.get(i).getValue());
					if(listRecord.get(i).getValue() > 200)
						airData.setEvaluation("HIGH");
					break;
			case Const.PM10:
					airData.setValue(listRecord.get(i).getValue());
					if(listRecord.get(i).getValue() > 150)
						airData.setEvaluation("HIGH");
					break;
			case Const.PM25:
					airData.setValue(listRecord.get(i).getValue());
					if(listRecord.get(i).getValue() > 50)
						airData.setEvaluation("HIGH");
					break;
			}
			
			listAirData.add(airData);
		}
		
		return listAirData;
	}
	
	public static String getJson(int air, List<RecordModel> listRecord) {
		List<AirData> listAirData = getList(air, listRecord);
		Map<Object, Object> map;
		List<Map<Object, Object>> listMap = new ArrayList<>();
		for (int i = 0; i < listAirData.size(); i++) {
			map = new HashMap<Object, Object>();
			map.put("label",
					listAirData.get(i).getLocation());
			map.put("indexLabel", listAirData.get(i).getEvaluation());
			//map.put("x", (i * 100 )/ listAirData.size() );
			map.put("y", listAirData.get(i).getValue());
			listMap.add(map);
		}
		return new Gson().toJson(listMap);
	}
	
	public static int randomData(int max, int min){
		return new Random().nextInt((max-min)+1) + min;
	}
	
	
	static class AirData{
		
		private String location = "";
		private float value = 0;
		private String evaluation = "";
		
		public String getEvaluation() {
			return evaluation;
		}
		public void setEvaluation(String evaluation) {
			this.evaluation = evaluation;
		}
		public String getLocation() {
			return location;
		}
		public void setLocation(String location) {
			this.location = location;
		}
		public float getValue() {
			return value;
		}
		public void setValue(float value) {
			this.value = value;
		}
		
		
	}

}

package vn.edu.uit.iot.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import vn.edu.uit.iot.model.RecordModel;

public class HandleData {


	private static List<AirData> getList(int air, List<RecordModel> listRecord){
		List<AirData> listAirData = new ArrayList<>();
		AirData airData;
		for(int i = 0; i<listRecord.size(); i++){
			airData =  new AirData();
			airData.setLocation(listRecord.get(i).getLocation().getLocationName());
			if(air == Const.CO){
				airData.setValue(listRecord.get(i).getCo());
				if(listRecord.get(i).getCo() > 30000)
					airData.setEvaluation("HIGH");
			}
			if(air == Const.SO2){
				airData.setValue(listRecord.get(i).getSo2());
				if(listRecord.get(i).getSo2() > 350)
					airData.setEvaluation("HIGH");
			}
			if(air == Const.O3){
				airData.setValue(listRecord.get(i).getO3());
				if(listRecord.get(i).getO3() > 200)
					airData.setEvaluation("HIGH");
			}
			if(air == Const.Pb){
				airData.setValue(listRecord.get(i).getPb());
				if(listRecord.get(i).getPb() > 1.5)
					airData.setEvaluation("HIGH");
			}
			if(air == Const.TSP){
				airData.setValue(listRecord.get(i).getTsp());
				if(listRecord.get(i).getTsp() > 200)
					airData.setEvaluation("HIGH");
			}
			if(air == Const.PM10){
				airData.setValue(listRecord.get(i).getPm10());
				if(listRecord.get(i).getPm10() > 150)
					airData.setEvaluation("HIGH");
			}
			if(air == Const.PM25){
				airData.setValue(listRecord.get(i).getPm25());
				if(listRecord.get(i).getPm25() > 50)
					airData.setEvaluation("HIGH");
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

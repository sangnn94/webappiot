package vn.edu.uit.iot.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.gson.Gson;

import vn.edu.uit.iot.model.RecordModel;

public class HandleData {


	private static List<AirData> getList(int air, List<RecordModel> listRecord) {
		List<AirData> listAirData = new ArrayList<>();
		AirData airData;
		for (int i = 0; i < listRecord.size(); i++) {
			airData = new AirData();
			airData.setLocation(listRecord.get(i).getLocation().getLocationName());
			if (air == Const.CO && listRecord.get(i).getAir().getId() == Const.CO) {
				airData.setValue(listRecord.get(i).getValue());
				if (listRecord.get(i).getValue() > 30000)
					airData.setEvaluation("Danger");
				else if(listRecord.get(i).getValue() < 30000 && listRecord.get(i).getValue() > 27000)
					airData.setEvaluation("Warning");
				else
					airData.setEvaluation("Normal");
				listAirData.add(airData);
			}
			if (air == Const.SO2 && listRecord.get(i).getAir().getId() == Const.SO2) {
				airData.setValue(listRecord.get(i).getValue());
				if (listRecord.get(i).getValue() > 350)
					airData.setEvaluation("Danger");
				else if(listRecord.get(i).getValue() < 350 && listRecord.get(i).getValue() > 315)
					airData.setEvaluation("Warning");
				else
					airData.setEvaluation("Normal");
				listAirData.add(airData);
			}
			if (air == Const.O3 && listRecord.get(i).getAir().getId() == Const.O3) {
				airData.setValue(listRecord.get(i).getValue());
				if (listRecord.get(i).getValue() > 200)
					airData.setEvaluation("Danger");
				else if(listRecord.get(i).getValue() < 200 && listRecord.get(i).getValue() < 180)
					airData.setEvaluation("Warning");
				else
					airData.setEvaluation("Normal");
				listAirData.add(airData);
			}
			if (air == Const.Pb && listRecord.get(i).getAir().getId() == Const.Pb) {
				airData.setValue(listRecord.get(i).getValue());
				if (listRecord.get(i).getValue() > 1.5)
					airData.setEvaluation("Danger");
				else if(listRecord.get(i).getValue() < 1.5 && listRecord.get(i).getValue() > 1.35)
					airData.setEvaluation("Warning");
				else
					airData.setEvaluation("Normal");
				listAirData.add(airData);
			}
			if (air == Const.TSP && listRecord.get(i).getAir().getId() == Const.TSP) {
				airData.setValue(listRecord.get(i).getValue());
				if (listRecord.get(i).getValue() > 200)
					airData.setEvaluation("Danger");
				else if(listRecord.get(i).getValue() < 200 && listRecord.get(i).getValue() < 180)
					airData.setEvaluation("Warning");
				else
					airData.setEvaluation("Normal");
				listAirData.add(airData);
			}
			if (air == Const.PM10 && listRecord.get(i).getAir().getId() == Const.PM10) {
				airData.setValue(listRecord.get(i).getValue());
				if (listRecord.get(i).getValue() > 150)
					airData.setEvaluation("Danger");
				else if(listRecord.get(i).getValue() < 150 && listRecord.get(i).getValue() < 135)
					airData.setEvaluation("Warning");
				else
					airData.setEvaluation("Normal");
				listAirData.add(airData);
			}
			if (air == Const.PM25 && listRecord.get(i).getAir().getId() == Const.PM25) {
				airData.setValue(listRecord.get(i).getValue());
				if (listRecord.get(i).getValue() > 50)
					airData.setEvaluation("Danger");
				else if(listRecord.get(i).getValue() < 50 && listRecord.get(i).getValue() < 45)
					airData.setEvaluation("Warning");
				else
					airData.setEvaluation("Normal");
				listAirData.add(airData);
			}
			if (air == Const.NO2 && listRecord.get(i).getAir().getId() == Const.NO2) {
				airData.setValue(listRecord.get(i).getValue());
				if (listRecord.get(i).getValue() > 200)
					airData.setEvaluation("Danger");
				else if(listRecord.get(i).getValue() < 200 && listRecord.get(i).getValue() < 180)
					airData.setEvaluation("Warning");
				else
					airData.setEvaluation("Normal");
				listAirData.add(airData);
			}

			
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
			//map.put("indexLabel", listAirData.get(i).getEvaluation());
			if(listAirData.get(i).getEvaluation().equals("Danger"))
				map.put("color", "red");
			if(listAirData.get(i).getEvaluation().equals("Warning"))
				map.put("color", "orange");
			if(listAirData.get(i).getEvaluation().equals("Normal"))
				map.put("color", "green");
			map.put("y", listAirData.get(i).getValue());
			listMap.add(map);
		}
		
		return new Gson().toJson(listMap);
	}
	
	public static int randomData(int min, int max){
		Random r = new Random();
		int result = r.nextInt((max-min)+1)+min;
		return result;
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

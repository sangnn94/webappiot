package vn.edu.uit.iot.utils;


import java.util.Date;



public final class SingletonCurrentTimes {
	private static SingletonCurrentTimes INSTANCE = null;
	private  Date oneHour, eightHour, oneDay;
	private SingletonCurrentTimes(){
		Date date = new Date();
		this.oneHour = date;
		this.eightHour = date;
		this.oneDay = date;
	}
	public static SingletonCurrentTimes getInstance() {
		if(INSTANCE == null){
			INSTANCE = new SingletonCurrentTimes();
		}
		return INSTANCE;
	}
	public  Date getOneHour() {
		return oneHour;
	}
	public  void setOneHour(Date onehour) {
		this.oneHour = onehour;
	}
	public  Date getEightHour() {
		return eightHour;
	}
	public  void setEightHour(Date eighthour) {
		this.eightHour = eighthour;
	}
	public  Date getOneday() {
		return oneDay;
	}
	public  void setOneday(Date oneday) {
		this.oneDay = oneday;
	}
	
	
}

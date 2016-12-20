package vn.edu.uit.iot.utils;


import java.util.Date;

public final class SingletonCurrentTimes {
	private static SingletonCurrentTimes INSTANCE = null;
	private static Date currentTime;
	private SingletonCurrentTimes(){
		
	}
	public static SingletonCurrentTimes getInstance() {
		if(INSTANCE == null)
			INSTANCE = new SingletonCurrentTimes();
		return INSTANCE;
	}
	public static Date getCurrentTime() {
		return currentTime;
	}
	public static void setCurrentTime(Date currentTime) {
		SingletonCurrentTimes.currentTime = currentTime;
		
	}
	
}

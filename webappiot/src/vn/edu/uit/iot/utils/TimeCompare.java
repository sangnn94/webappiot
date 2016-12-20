package vn.edu.uit.iot.utils;

import java.util.Date;

public class TimeCompare {
	public static boolean oneHour(){
		Date now = new Date();
		long compare = now.getTime() - SingletonCurrentTimes.getInstance().getOneHour().getTime();
		if(compare < Const.Times.ONE_HOUR)
			return false;
		return true;
	}
	
	public static boolean eightHour(){
		Date now = new Date();
		long compare = now.getTime() - SingletonCurrentTimes.getInstance().getEightHour().getTime();
		if(compare < Const.Times.EIGHT_HOUR)
			return false;
		return true;
	}
	
	public static boolean oneDay(){
		Date now = new Date();
		long compare = now.getTime() - SingletonCurrentTimes.getInstance().getOneday().getTime();
		if(compare < Const.Times.ONE_DAY)
			return false;
		return true;
	}
	
}

package vn.edu.uit.iot.utils;

public class Const {
	public static final int CO = 2;
	public static final int SO2 = 1;
	public static final int O3 = 4;
	public static final int Pb = 8;
	public static final int TSP = 5;
	public static final int PM10 = 6;
	public static final int PM25 = 7;
	public static final int NO2 = 3;
	
	public static final int TIME_STANDARD_ONE_HOUR = 1;
	public static final int TIME_STANDARD_ONE_DAY = 24;
	public static final int TIME_STANDARD_ONE_YEAR = 365;
	public static final int TIME_STANDARD_EIGHT_HOUR = 8;
	

	public static class AirStrandard {
		public static class OneHour {
			public static final float CO = 30000;
			public static final float SO2 = 350;
			public static final float O3 = 200;
			public static final float NO2 = 200;
			public static final float TSP = 300;
		
		}

		public static class EightHour {
			public static final float CO = 10000;
			public static final float O3 = 120;
			public static final float TSP = 200;
		}

		public static class OneDay {
			public static final float Pb = (float) 1.5;
			public static final float SO2 = 125;
			public static final float PM10 = 150;
			public static final float NO2 = 100;
			public static final float PM25 = 50;
		}
		
		public static class OneYear {
			public static final float Pb = (float) 0.5;
			public static final float SO2 = 50;
			public static final float PM10 = 50;
			public static final float NO2 = 40;
			public static final float TSP = 100;
			public static final float PM25 = 25;
		}
	}
	
	public static class Times{
		//time millisecond
		public static final long ONE_HOUR = 3600000;
		public static final long EIGHT_HOUR = 28800000;
		public static final long ONE_DAY = 86400000;
		
	}
}

package vn.edu.uit.iot.model;

public class GpsJson {
	private String id;
	private String gps;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGps() {
		return gps;
	}

	public void setGps(String gps) {
		this.gps = gps;
	}

	@Override
	public String toString() {
		return "GpsJson [id=" + id + ", gps=" + gps + "]";
	}

}

package vn.edu.uit.iot.dao;

import java.util.List;

import vn.edu.uit.iot.model.LocationModel;

public interface LocationDAO {
	
	public LocationModel getLocation(int locationID);

	public List<LocationModel> getAllLocation();
}

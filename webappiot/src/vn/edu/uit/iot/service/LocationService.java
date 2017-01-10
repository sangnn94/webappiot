package vn.edu.uit.iot.service;

import java.util.List;

import vn.edu.uit.iot.model.LocationModel;

public interface LocationService {
	
	public LocationModel get(int id);
	
	public List<LocationModel> getAll();
}

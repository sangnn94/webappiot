package vn.edu.uit.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.uit.iot.dao.LocationDAO;
import vn.edu.uit.iot.model.LocationModel;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationDAO locationDao;

	@Transactional
	public LocationModel get(int id) {
		return this.locationDao.getLocation(id);
	}

	@Transactional
	public List<LocationModel> getAll() {
		return this.locationDao.getAllLocation();
	}

}

package vn.edu.uit.iot.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.iot.model.LocationModel;

@Repository
public class LocationDaoImpl implements LocationDAO {

	@Autowired
	private SessionFactory mSession;

	@Override
	public LocationModel getLocation(int locationID) {
		Session ss = mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		LocationModel location = (LocationModel) ss.get(LocationModel.class, locationID);
		ts.commit();
		return location;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<LocationModel> getAllLocation() {
		Session ss = mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		List<LocationModel> arrLocation = ss.createQuery("from LocationModel").list();
		ts.commit();
		return arrLocation;
	}

}

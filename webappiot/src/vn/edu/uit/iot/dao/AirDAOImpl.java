package vn.edu.uit.iot.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.iot.model.AirModel;
import vn.edu.uit.iot.model.RecordModel;

@Repository
public class AirDAOImpl implements AirDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public AirModel get(int id) {
		Transaction ts =  session().beginTransaction();
		AirModel air = (AirModel) session().get(AirModel.class, id);
		ts.commit();
		return air;
	}

}

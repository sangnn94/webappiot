package vn.edu.uit.iot.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.iot.model.AirModel;



@Repository
public class AirDAOimpl implements AirDAO {
	@Autowired
	private SessionFactory mSession;

	@Override
	public void insert(AirModel airModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.save(airModel);
		ts.commit();
		
	}

	@Override
	public void delete(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.delete(this.getData(id));;
		ts.commit();
		
	}

	@Override
	public void update(AirModel airModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.update(airModel);
		ts.commit();
		
	}

	@Override
	public AirModel getData(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		AirModel data = (AirModel) ss.get(AirModel.class, id);
		ts.commit();
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AirModel> getAll() {
		Session ss = mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		List<AirModel> arrData = ss.createQuery("from AirModel").list();
		ts.commit();
		return arrData;
	}
	
	
}

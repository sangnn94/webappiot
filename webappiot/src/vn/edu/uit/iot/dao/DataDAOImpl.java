package vn.edu.uit.iot.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.iot.model.DataModel;

@Repository
public class DataDAOImpl implements DataDAO{

	@Autowired
	private SessionFactory mSession;
	
	@Override
	public void insert(DataModel dataModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.save(dataModel);
		ts.commit();
		
	}

	@Override
	public void delete(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.delete(this.getData(id));
		ts.commit();
		
		
	}

	@Override
	public void update(DataModel dataModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.update(dataModel);
		ts.commit();
		
	}

	@Override
	public DataModel getData(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		DataModel data = (DataModel) ss.get(DataModel.class, id);
		ts.commit();
		return data;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DataModel> getAll() {
		Session ss = mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		List<DataModel> arrData = ss.createQuery("from DataModel").list();
		ts.commit();
		return arrData;
	}
	
}

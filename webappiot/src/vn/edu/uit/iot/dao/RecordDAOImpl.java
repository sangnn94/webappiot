package vn.edu.uit.iot.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.iot.model.RecordModel;

@Repository
public class RecordDAOImpl implements RecordDAO{

	@Autowired
	private SessionFactory mSession;
	
	@Override
	public void insert(RecordModel recordModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.save(recordModel);
		ts.commit();
	}

	@Override
	public void delete(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.delete(this.getRecord(id));
		ts.commit();
		
	}

	@Override
	public void update(RecordModel recordModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.update(recordModel);
		ts.commit();
		
	}

	@Override
	public RecordModel getRecord(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		RecordModel record = (RecordModel) ss.get(RecordModel.class, id);
		ts.commit();
		return record;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecordModel> getAll() {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		List<RecordModel> arrRecord = ss.createQuery("from RecordModel").list();
		ts.commit();
		return arrRecord;
	}

}

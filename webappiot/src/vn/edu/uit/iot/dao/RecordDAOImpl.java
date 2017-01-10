package vn.edu.uit.iot.dao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.iot.model.RecordModel;

@Repository
public class RecordDAOImpl implements RecordDAO {

	@Autowired
	private SessionFactory mSession;

	@Override
	public void insert(RecordModel recordModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		ss.save(recordModel);
		ts.commit();
	}

	@Override
	public void delete(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		ss.delete(this.getRecord(id));
		ts.commit();

	}

	@Override
	public void update(RecordModel recordModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		ss.update(recordModel);
		ts.commit();

	}

	@Override
	public RecordModel getRecord(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		RecordModel record = (RecordModel) ss.get(RecordModel.class, id);
		ts.commit();
		return record;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecordModel> getAll() {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		List<RecordModel> arrRecord = ss.createQuery("from RecordModel").list();
		ts.commit();
		return arrRecord;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecordModel> getLastest() {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		List<RecordModel> records = ss
				.createQuery("from RecordModel where (location.locationId, air.id, date) in"
						+ "(select location.locationId, air.id, max(date) "
						+ "from RecordModel group by air.id, location.locationId) order by location.locationId, air.id")
				.list();
		ts.commit();
		return records;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<RecordModel> getForDay(Date startDate, Date endDate) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String fromDate = format.format(startDate);
		String toDate= format.format(endDate);
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		List<RecordModel> records = ss.createQuery("from RecordModel where date between '" 
				+fromDate+
				"' and '"
				+toDate+"'").list();
		ts.commit();
		return records;
	}

}

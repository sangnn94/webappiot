package vn.edu.uit.iot.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.uit.iot.dao.RecordDAO;
import vn.edu.uit.iot.model.RecordModel;

@Service
public class RecordServiceImpl implements RecordService {

	@Autowired
	private RecordDAO recordDao;

	@Transactional
	public void insert(RecordModel recordModel) {
		this.recordDao.insert(recordModel);

	}

	@Transactional
	public void delete(int id) {
		this.recordDao.delete(id);

	}

	@Transactional
	public void update(RecordModel recordModel) {
		this.recordDao.update(recordModel);

	}

	@Transactional
	public RecordModel getData(int id) {
		return this.recordDao.getRecord(id);
	}

	@Transactional
	public List<RecordModel> getAll() {
		return this.recordDao.getAll();
	}

	@Override
	public List<RecordModel> getLastest() {
		return recordDao.getLastest();
	}

	@Override
	public List<RecordModel> getForDate(Date fromDate, Date toDate) {	
		return recordDao.getForDay(fromDate, toDate);
	}

}

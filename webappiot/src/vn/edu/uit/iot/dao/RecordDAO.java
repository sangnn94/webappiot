package vn.edu.uit.iot.dao;


import java.util.Date;
import java.util.List;

import vn.edu.uit.iot.model.RecordModel;

public interface RecordDAO {

	public void insert(RecordModel recordModel);

	public void delete(int id);

	public void update(RecordModel recordModel);

	public RecordModel getRecord(int id);

	public List<RecordModel> getAll();
	
	public List<RecordModel> getLastest();
	
	public List<RecordModel> getForDay(Date startDate, Date endDate);
	
}

package vn.edu.uit.iot.service;

import java.util.List;

import vn.edu.uit.iot.model.RecordModel;

public interface RecordService {

	public void insert(RecordModel recordModel);
	
	public void delete(int id);
	
	public void update(RecordModel recordModel);
	
	public RecordModel getData(int id);
	
	public List<RecordModel> getAll();
	
}

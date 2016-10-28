package vn.edu.uit.iot.service;

import java.util.List;

import vn.edu.uit.iot.model.DataModel;

public interface DataService {

	public void insert(DataModel dataModel);
	
	public void delete(int id);
	
	public void update(DataModel dataModel);
	
	public DataModel getData(int id);
	
	public List<DataModel> getAll();
}

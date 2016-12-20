package vn.edu.uit.iot.dao;

import java.util.List;

import vn.edu.uit.iot.model.DataModel;

public interface DataDAO {

	public void insert(DataModel dataModel);

	public void delete(int id);

	public void update(DataModel dataModel);

	public DataModel get(int id);

	public List<DataModel> getAll();

}

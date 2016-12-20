package vn.edu.uit.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.uit.iot.dao.DataDAO;
import vn.edu.uit.iot.model.DataModel;

@Service
public class DataServiceImpl implements DataService {

	@Autowired
	private DataDAO dataDao;

	@Transactional
	public void insert(DataModel dataModel) {
		this.dataDao.insert(dataModel);

	}

	@Transactional
	public void delete(int id) {
		this.dataDao.delete(id);

	}

	@Transactional
	public void update(DataModel dataModel) {
		this.dataDao.update(dataModel);

	}

	@Transactional
	public DataModel getData(int id) {
		return this.dataDao.get(id);
	}

	@Transactional
	public List<DataModel> getAll() {
		return this.dataDao.getAll();
	}

}

package vn.edu.uit.iot.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vn.edu.uit.iot.dao.AirDAO;
import vn.edu.uit.iot.model.AirModel;

@Service
public class AirServiceImpl implements AirService {
	@Autowired
	private AirDAO airDao;

	@Override
	public void insert(AirModel airModel) {
		
		this.airDao.insert(airModel);
	}

	@Override
	public void delete(int id) {
		
		this.airDao.delete(id);
	}

	@Override
	public void update(AirModel airModel) {
		this.airDao.update(airModel);
		
	}

	@Override
	public AirModel getData(int id) {
		
		return this.airDao.getData(id);
	}

	@Override
	public List<AirModel>  getAll(){
		return this.airDao.getAll();
	}
		


}

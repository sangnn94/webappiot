package vn.edu.uit.iot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.uit.iot.dao.AirDAO;
import vn.edu.uit.iot.model.AirModel;

@Service
public class AirServiceImpl implements AirService {
	@Autowired
	private AirDAO airDao;

	@Override
	@Transactional
	public AirModel get(int id) {
		// TODO Auto-generated method stub
		return airDao.get(id);
	}

}

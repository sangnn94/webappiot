package vn.edu.uit.iot.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.uit.iot.dao.GatewayDAO;
import vn.edu.uit.iot.model.GatewayModel;

@Service
public class GatewayServiceImpl implements GatewayService {

	@Autowired
	private GatewayDAO gatewayDao;

	@Transactional
	public void insert(GatewayModel gatewayModel) {
		this.gatewayDao.insert(gatewayModel);

	}

	@Transactional
	public void delete(int id) {
		this.gatewayDao.delete(id);

	}

	@Transactional
	public void update(GatewayModel gatewayModel) {
		this.gatewayDao.update(gatewayModel);

	}

	@Transactional
	public GatewayModel getData(int id) {
		return this.gatewayDao.getGateway(id);
	}

	@Transactional
	public List<GatewayModel> getAll() {
		return this.gatewayDao.getAll();
	}

}

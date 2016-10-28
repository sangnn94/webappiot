package vn.edu.uit.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.uit.iot.dao.NodeDAO;
import vn.edu.uit.iot.model.NodeModel;

@Service
public class NodeServiceImpl implements NodeService {

	@Autowired
	private NodeDAO nodeDao;

	@Transactional
	public void insert(NodeModel nodeModel) {
		this.nodeDao.insert(nodeModel);

	}

	@Transactional
	public void delete(int id) {
		this.nodeDao.delete(id);

	}

	@Transactional
	public void update(NodeModel nodeModel) {
		this.nodeDao.update(nodeModel);

	}

	@Transactional
	public NodeModel getData(int id) {
		return this.nodeDao.getNode(id);
	}

	@Transactional
	public List<NodeModel> getAll() {
		return this.nodeDao.getAll();
	}

}

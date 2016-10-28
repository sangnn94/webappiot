package vn.edu.uit.iot.dao;

import java.util.List;

import vn.edu.uit.iot.model.NodeModel;

public interface NodeDAO {

	public void insert(NodeModel nodeModel);

	public void delete(int id);

	public void update(NodeModel nodeModel);

	public NodeModel getNode(int id);

	public List<NodeModel> getAll();
}

package vn.edu.uit.iot.service;

import java.util.List;

import vn.edu.uit.iot.model.NodeModel;



public interface NodeService {
	
	public void insert(NodeModel nodeModel);
	
	public void delete(int id);
	
	public void update(NodeModel nodeModel);
	
	public NodeModel getData(int id);
	
	public List<NodeModel> getAll();

}

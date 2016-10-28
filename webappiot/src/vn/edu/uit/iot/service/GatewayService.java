package vn.edu.uit.iot.service;

import java.util.List;

import vn.edu.uit.iot.model.GatewayModel;


public interface GatewayService {

	public void insert(GatewayModel gatewayModel);
	
	public void delete(int id);
	
	public void update(GatewayModel gatewayModel);
	
	public GatewayModel getData(int id);
	
	public List<GatewayModel> getAll();
}

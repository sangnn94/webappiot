package vn.edu.uit.iot.dao;

import java.util.List;

import vn.edu.uit.iot.model.GatewayModel;

public interface GatewayDAO {

	public void insert(GatewayModel gatewayModel);

	public void delete(int id);

	public void update(GatewayModel gatewayModel);

	public GatewayModel getGateway(int id);

	public List<GatewayModel> getAll();
}

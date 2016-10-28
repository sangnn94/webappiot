package vn.edu.uit.iot.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.iot.model.GatewayModel;

@Repository
public class GatewayDAOImpl implements GatewayDAO {

	@Autowired
	private SessionFactory mSession;

	@Override
	public void insert(GatewayModel gatewayModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		ss.save(gatewayModel);
		ts.commit();

	}

	@Override
	public void delete(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		ss.delete(this.getGateway(id));
		ts.commit();

	}

	@Override
	public void update(GatewayModel gatewayModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		ss.update(gatewayModel);
		ts.commit();

	}

	@Override
	public GatewayModel getGateway(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		GatewayModel gateway = (GatewayModel) ss.get(GatewayModel.class, id);
		ts.commit();
		return gateway;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<GatewayModel> getAll() {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts = ss.beginTransaction();
		List<GatewayModel> arrGateway = ss.createQuery("from GatewayModel").list();
		ts.commit();
		return arrGateway;
	}

}

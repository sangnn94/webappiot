package vn.edu.uit.iot.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.classic.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import vn.edu.uit.iot.model.NodeModel;

@Repository
public class NodeDAOImpl implements NodeDAO{

	@Autowired
	private SessionFactory mSession;
	
	@Override
	public void insert(NodeModel nodeModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.update(nodeModel);
		ts.commit();
		
	}

	@Override
	public void delete(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.delete(this.getNode(id));
		ts.commit();
		
	}

	@Override
	public void update(NodeModel nodeModel) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		ss.update(nodeModel);
		ts.commit();
		
	}

	@Override
	public NodeModel getNode(int id) {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		NodeModel node =(NodeModel) ss.get(NodeModel.class, id);
		ts.commit();
		return node;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<NodeModel> getAll() {
		Session ss = this.mSession.getCurrentSession();
		Transaction ts =  ss.beginTransaction();
		List<NodeModel> arrNode = ss.createQuery("from NodeModel").list();
		ts.commit();
		return arrNode;
	}

}
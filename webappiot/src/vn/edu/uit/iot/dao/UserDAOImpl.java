package vn.edu.uit.iot.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.edu.uit.iot.model.UserModel;

@Transactional
@Repository
@Component("userDAOImpl")
public class UserDAOImpl implements UserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public Session session() {
		return sessionFactory.getCurrentSession();
	}

	@Transactional
	@Override
	public void create(UserModel user) {
		// TODO Auto-generated method stub
		Transaction ts = session().beginTransaction();
		user.setPassword(user.getPassword());
		session().save(user);
		ts.commit();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		Transaction ts = session().beginTransaction();
		List<UserModel> users = session().createQuery("from UserModel").list();
		ts.commit();
		return users;
	}

}

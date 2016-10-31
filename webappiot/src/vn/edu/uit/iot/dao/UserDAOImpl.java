package vn.edu.uit.iot.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
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
	private PasswordEncoder passwordEncoder;

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
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		session().save(user);
		ts.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		return session().createQuery("from UserModel").list();
	}

}

package vn.edu.uit.iot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import vn.edu.uit.iot.dao.UserDAO;
import vn.edu.uit.iot.model.UserModel;
@Service("usersServiceImpl")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;

	@Override
	public void create(UserModel user) {
		// TODO Auto-generated method stub
		userDao.create(user);

	}

	@Secured("ROLE_ADMIN")
	@Override
	public List<UserModel> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}

}

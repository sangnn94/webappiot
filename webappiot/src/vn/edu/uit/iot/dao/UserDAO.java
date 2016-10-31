package vn.edu.uit.iot.dao;

import java.util.List;

import vn.edu.uit.iot.model.UserModel;

public interface UserDAO {
	void create(UserModel user);
	List<UserModel> getAll();
}

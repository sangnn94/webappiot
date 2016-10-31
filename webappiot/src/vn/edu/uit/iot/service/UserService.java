package vn.edu.uit.iot.service;

import java.util.List;

import vn.edu.uit.iot.model.UserModel;

public interface UserService {
	void create(UserModel user);
	List<UserModel> getAll();

}

package vn.edu.uit.iot.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import vn.edu.uit.iot.model.UserModel;

@Repository
public interface UserDAO {
	UserModel findByUsername(String username);
	List<UserModel> getAll();
	void create(UserModel user);
}

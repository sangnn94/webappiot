package vn.edu.uit.iot.dao;

import java.util.List;

import vn.edu.uit.iot.model.AirModel;


public interface AirDAO {

		public void insert(AirModel airModel);

		public void delete(int id);

		public void update(AirModel airModel);

		public AirModel getData(int id);

		public List<AirModel> getAll();
		


}


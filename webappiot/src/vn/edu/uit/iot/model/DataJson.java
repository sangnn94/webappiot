package vn.edu.uit.iot.model;

import java.util.Set;

public class DataJson {
	/**
	 * 
	 */
	private String id;
	private Set<Value> datas;

	public DataJson() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Set<Value> getDatas() {
		return datas;
	}

	public void setDatas(Set<Value> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "DataJson [id=" + id + ", datas=" + datas + "]";
	}

}

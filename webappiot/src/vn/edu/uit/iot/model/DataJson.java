package vn.edu.uit.iot.model;

import java.util.List;

public class DataJson {
	/**
	 * 
	 */
	private String id;
	private List<Value> datas;

	public DataJson() {
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Value> getDatas() {
		return datas;
	}

	public void setDatas(List<Value> datas) {
		this.datas = datas;
	}

	@Override
	public String toString() {
		return "DataJson [id=" + id + ", datas=" + datas + "]";
	}

}

class Value {
	private int id;
	private float value;

	public Value() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Value [id=" + id + ", value=" + value + "]";
	}

}

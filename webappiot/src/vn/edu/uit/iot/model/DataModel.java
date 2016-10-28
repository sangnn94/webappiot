package vn.edu.uit.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DATA")
public class DataModel {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "NID")
	private int nodeID;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "DATE")
	private String date;

	public DataModel() {
		super();
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNodeID() {
		return nodeID;
	}

	public void setNodeID(int nodeID) {
		this.nodeID = nodeID;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	

	

}

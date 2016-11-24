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
	@Column(name = "ID")
	private String id;

	@Column(name = "NID")
	private String nodeID;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "DATE")
	private String date;

	public DataModel() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNodeID() {
		return nodeID;
	}

	public void setNodeID(String nodeID) {
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

	@Override
	public String toString() {
		return "DataModel [id=" + id + ", nodeID=" + nodeID + ", value=" + value + ", date=" + date + "]";
	}

}

package vn.edu.uit.iot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "DATA")
public class DataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@Column(name = "NID", length = 100)
	private String nodeID;

	@Transient
	private String value;

	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;

	public DataModel() {

	}

	public DataModel(String nodeID, String value) {
		this.nodeID = nodeID;
		this.value = value;
	}

	@PrePersist
	protected void onCreate() {
		if (date == null) {
			date = new Date();
		}
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "DataModel [id=" + id + ", nodeID=" + nodeID + ", value=" + value + ", date=" + date + "]";
	}

}

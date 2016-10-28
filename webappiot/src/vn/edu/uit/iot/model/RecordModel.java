package vn.edu.uit.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RECORD")
public class RecordModel {

	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "LCID")
	private int locationID;

	@Column(name = "DATE")
	private String date;

	@Column(name = "VALUE")
	private String value;

	@Column(name = "EVALUATION")
	private String evaluation;

	public RecordModel() {
		super();
	}

	public RecordModel(int id, int locationID, String date, String value, String evaluation) {
		super();
		this.id = id;
		this.locationID = locationID;
		this.date = date;
		this.value = value;
		this.evaluation = evaluation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

}

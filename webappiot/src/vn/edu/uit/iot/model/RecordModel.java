package vn.edu.uit.iot.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "RECORD")
public class RecordModel {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@ManyToOne
	@JoinColumn(name = "LOCATION_ID", nullable=false)
	private LocationModel location;
	
	@ManyToOne
	@JoinColumn(name = "AIR_ID", nullable=false)
	private AirModel airId;
	
	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;

	@Column(name = "EVALUATION", length = 100)
	private String evaluation;
	
	@Column(name = "VALUE")
	private float value;
	
	@Column(name = "TIME")
	private float timeStandard;




	public RecordModel() {
	}

	public RecordModel(int id, int locationID, Date date, String evaluation) {
		this.id = id;
		this.date = date;
		this.evaluation = evaluation;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public LocationModel getLocation() {
		return location;
	}

	public void setLocation(LocationModel location) {
		this.location = location;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getEvaluation() {
		return evaluation;
	}

	public void setEvaluation(String evaluation) {
		this.evaluation = evaluation;
	}

	public AirModel getAirId() {
		return airId;
	}

	public void setAirId(AirModel airId) {
		this.airId = airId;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	public float getTimeStandard() {
		return timeStandard;
	}

	public void setTimeStandard(float timeStandard) {
		this.timeStandard = timeStandard;
	}

	

}

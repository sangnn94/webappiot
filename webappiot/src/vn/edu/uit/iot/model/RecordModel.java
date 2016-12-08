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
	
	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;

	@Column(name = "EVALUATION", length = 100)
	private String evaluation;

	@Column(name = "CO", nullable = false)
	private float co;
	@Column(name = "SO2", nullable = false)
	private float so2;
	@Column(name = "O3", nullable = false)
	private float o3;
	@Column(name = "PB", nullable = false)
	private float pb;
	@Column(name = "TSP", nullable = false)
	private float tsp;
	@Column(name = "PM10", nullable = false)
	private float pm10;
	@Column(name = "PM25", nullable = false)
	private float pm25;


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

	public float getCo() {
		return co;
	}

	public void setCo(float co) {
		this.co = co;
	}

	public float getO3() {
		return o3;
	}

	public void setO3(float o3) {
		this.o3 = o3;
	}

	public float getPb() {
		return pb;
	}

	public float getSo2() {
		return so2;
	}

	public void setSo2(float so2) {
		this.so2 = so2;
	}

	public void setPb(float pb) {
		this.pb = pb;
	}

	public float getTsp() {
		return tsp;
	}

	public void setTsp(float tsp) {
		this.tsp = tsp;
	}

	public float getPm10() {
		return pm10;
	}

	public void setPm10(float pm10) {
		this.pm10 = pm10;
	}

	public float getPm25() {
		return pm25;
	}

	public void setPm25(float pm25) {
		this.pm25 = pm25;
	}

}

package vn.edu.uit.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "VALUE")
public class ValueModel {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "DATA_ID", nullable=false)
	private DataModel dataId;
	
	@ManyToOne
	@JoinColumn(name = "AIR_ID", nullable=false)
	private AirModel airId;
	
	@Column(name = "VALUE")
	private float value;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public DataModel getDataId() {
		return dataId;
	}

	public void setDataId(DataModel dataId) {
		this.dataId = dataId;
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
	
	
}

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
	@JoinColumn(name = "DATA_ID", nullable = false)
	private DataModel data;

	@ManyToOne
	@JoinColumn(name = "AIR_ID", nullable = false)
	private AirModel air;

	@Column(name = "VALUE")
	private float value;

	public ValueModel() {
		// TODO Auto-generated constructor stub
	}

	public ValueModel(AirModel air, float value) {
		this.air = air;
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DataModel getData() {
		return data;
	}

	public void setData(DataModel data) {
		this.data = data;
	}

	public AirModel getAir() {
		return air;
	}

	public void setAir(AirModel air) {
		this.air = air;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

}

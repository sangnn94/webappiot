package vn.edu.uit.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GATEWAY")
public class GatewayModel {
	@Id
	@Column(name = "ID")
	private int id;

	@Column(name = "LCID")
	private int locationID;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "NUMNODE")
	private int numNode;

	public GatewayModel() {
		super();
	}

	public GatewayModel(int id, int locationID, String address, int numNode) {
		super();
		this.id = id;
		this.locationID = locationID;
		this.address = address;
		this.numNode = numNode;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getNumNode() {
		return numNode;
	}

	public void setNumNode(int numNode) {
		this.numNode = numNode;
	}

}

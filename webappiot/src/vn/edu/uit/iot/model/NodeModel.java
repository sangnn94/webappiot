package vn.edu.uit.iot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "NODE")
public class NodeModel {

	@Id
	@Column(name = "ID", length = 100)
	private String id;

	@Column(name = "GWID", length = 100)
	private String gatewayID;

	@Column(name = "LCID")
	private int locationID;

	@Column(name = "USERID")
	private int userID;

	@Column(name = "ADDRESS")
	private String address;

	public NodeModel() {
		super();
	}

	public NodeModel(String id, String gatewayID, int locationID, int userID, String address) {
		super();
		this.id = id;
		this.gatewayID = gatewayID;
		this.locationID = locationID;
		this.userID = userID;
		this.address = address;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getGatewayID() {
		return gatewayID;
	}

	public void setGatewayID(String gatewayID) {
		this.gatewayID = gatewayID;
	}

	public int getLocationID() {
		return locationID;
	}

	public void setLocationID(int locationID) {
		this.locationID = locationID;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}

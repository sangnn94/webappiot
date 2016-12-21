package vn.edu.uit.iot.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.validator.constraints.NotBlank;

import vn.edu.uit.iot.validator.GatewayIdExist;

@Entity
@Table(name = "GATEWAY")
public class GatewayModel {
	@Id
	@Column(name = "ID", length = 100)
	@NotBlank
	@GatewayIdExist
	private String id;

	@Column(name = "LONGITUDE")
	private float longitude;

	@Column(name = "LATITUDE")
	private float latitude;
	
	@NotBlank
	@Column(name = "ADDRESS")
	private String address;

	@ManyToOne
	@JoinColumn(name = "LOCATION_ID", nullable = false)
	private LocationModel location;

	@ManyToOne
	@JoinColumn(name = "USER_ID", nullable = false)
	private UserModel user;

	@OneToMany(mappedBy = "gateway", fetch=FetchType.EAGER)
	private Set<NodeModel> nodes;

	
	public GatewayModel() {
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public float getLongitude() {
		return longitude;
	}

	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}

	public float getLatitude() {
		return latitude;
	}

	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}

	public LocationModel getLocation() {
		return location;
	}

	public void setLocation(LocationModel location) {
		this.location = location;
	}

	public Set<NodeModel> getNodes() {
		return nodes;
	}

	public void setNodes(Set<NodeModel> nodes) {
		this.nodes = nodes;
	}

	public UserModel getUser() {
		return user;
	}

	public void setUser(UserModel user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "GatewayModel [id=" + id + ", longitude=" + longitude + ", latitude=" + latitude + ", address=" + address
				+ ", location=" + location + ", user=" + user + ", nodes=" + nodes + "]";
	}
	
}

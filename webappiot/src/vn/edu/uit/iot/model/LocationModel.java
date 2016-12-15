package vn.edu.uit.iot.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LOCATION")
public class LocationModel {

	@Id
	@Column(name = "ID")
	private int locationId;
	
	@Column(name = "NAME", length=50)
	private String locationName;
	
	@OneToMany(mappedBy="location")
	private Set<GatewayModel> gateways;
	
	public LocationModel() {
	}

	public LocationModel(int locationId, String locationName) {
		this.locationId = locationId;
		this.locationName = locationName;
	}

	public int getLocationId() {
		return locationId;
	}

	public void setLocationId(int locationId) {
		this.locationId = locationId;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Override
	public String toString() {
		return "LocationModel [locationId=" + locationId + ", locationName=" + locationName + "]";
	}

}

package vn.edu.uit.iot.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "NODE")
public class NodeModel {
	@Id
	@Column(name = "ID", length = 100)
	private String id;

	@ManyToOne
	@JoinColumn(name = "GATEWAY_ID", nullable = false)
	private GatewayModel gateway;

	@Column(name = "ADDRESS")
	private String address;

	@OneToMany(mappedBy = "node")
	private List<DataModel> datas;

	public NodeModel() {
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

	public GatewayModel getGateway() {
		return gateway;
	}

	public void setGateway(GatewayModel gateway) {
		this.gateway = gateway;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NodeModel other = (NodeModel) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}

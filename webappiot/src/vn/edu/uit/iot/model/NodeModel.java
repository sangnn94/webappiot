package vn.edu.uit.iot.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotBlank;


@Entity
@Table(name = "NODE")
public class NodeModel {
	@Id
	@Column(name = "ID", length = 100)
	@NotBlank
	private String id;
	
	@ManyToOne
	@JoinColumn(name = "GATEWAY_ID", nullable = false)
	private GatewayModel gateway;
	
	@Column(name = "ADDRESS")
	@NotBlank
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

}

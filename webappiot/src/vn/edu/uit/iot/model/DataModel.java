package vn.edu.uit.iot.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "DATA")
public class DataModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "NODE_ID", nullable = false)
	private NodeModel node;

	@Column(name = "DATE")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	@OneToMany(mappedBy="value")
	private Set<ValueModel> value;
	
	public DataModel() {

	}

	public DataModel(String nodeID, String value) {

	}

	@PrePersist
	protected void onCreate() {
		if (date == null) {
			date = new Date();
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public NodeModel getNode() {
		return node;
	}

	public void setNode(NodeModel node) {
		this.node = node;
	}



	public Set<ValueModel> getValue() {
		return value;
	}

	public void setValue(Set<ValueModel> value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "DataModel [id=" + id + ", node=" + node + ", date=" + date + ", value=" + value + "]";
	}
	
}

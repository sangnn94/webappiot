package vn.edu.uit.iot.model;

import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cascade;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import vn.edu.uit.iot.validator.PasswordMatches;
import vn.edu.uit.iot.validator.UsernameExist;

@Entity
@Table(name = "USER")
@PasswordMatches
public class UserModel {
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "USERNAME", length = 20, unique = true)
	@NotBlank
	@Size(min = 5, max = 20)
	@UsernameExist
	private String username;

	@Column(name = "EMAIL", unique = true)
	@NotBlank
	@Email
	private String email;

	@Column(name = "PASSWORD", length = 60)
	@NotBlank
	@Size(min = 8)
	private String password;

	@Transient
	private String matchingPassword;

	@Column(name = "PERMISSION", length = 10)
	private String permission;

	@Column(name = "ENABLED")
	private boolean enabled = true;

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@MapKey
	private Map<String, GatewayModel> gateways;

	public UserModel() {
		// TODO Auto-generated constructor stub
	}

	public UserModel(String username, String password, String email, String permission) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.permission = permission;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public Map<String, GatewayModel> getGateways() {
		return gateways;
	}

	public void setGateways(Map<String, GatewayModel> gateways) {
		this.gateways = gateways;
	}

	public String getPermission() {
		return permission;
	}

	public void setPermission(String permission) {
		this.permission = permission;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", username=" + username + ", email=" + email + ", permission=" + permission
				+ ", enabled=" + enabled + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		result = prime * result + ((permission == null) ? 0 : permission.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserModel other = (UserModel) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (permission == null) {
			if (other.permission != null)
				return false;
		} else if (!permission.equals(other.permission))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

}

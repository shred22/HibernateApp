package daoClasses;

import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="UsrDetails")
public class UserDetails {

	@Id
	@GeneratedValue
	private int userId;
	private String name;
	private String email;
	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="address" , joinColumns=@JoinColumn(name="userId"))
	@Column(name="street")
	private List<String> userAddresses;
	
	

	public UserDetails(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}
	public List<String> getUserAddresses() {
		return userAddresses;
	}
	public void setUserAddresses(List<String> userAddresses) {
		this.userAddresses = userAddresses;
	}
	public UserDetails() {
		super();
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}	
}

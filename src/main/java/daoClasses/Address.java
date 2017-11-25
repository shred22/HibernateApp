package daoClasses;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {

	@Id
	private int houseNo;
	private String street;
	private int userId;
		
	public Address(String street, int houseNo, int userId) {
		super();
		this.street = street;
		this.houseNo = houseNo;
		this.userId = userId;
	}
	public Address() {
		super();
	}
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
}

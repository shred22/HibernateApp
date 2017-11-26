package oneToManyDemo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Customers {

	@Id
	private int cust_id;
	private String cust_name;
	@OneToMany(cascade = CascadeType.ALL, mappedBy="cust")
	private Set<Orders> cust_Orders;
	public int getCust_id() {
		return cust_id;
	}
	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_name() {
		return cust_name;
	}
	public void setCust_name(String cust_name) {
		this.cust_name = cust_name;
	}
	public Set<Orders> getCust_Orders() {
		return cust_Orders;
	}
	public void setCust_Orders(Set<Orders> cust_Orders) {
		this.cust_Orders = cust_Orders;
	}
	
	
	
	
}

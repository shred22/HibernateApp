package oneToManyDemo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Orders {

	@Id
	private int order_id;
	private String name;
	@ManyToOne
	@JoinColumn(name="customer_id")
	private Customers cust;
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Customers getCust() {
		return cust;
	}
	public void setCust(Customers cust) {
		this.cust = cust;
	}
	
	
	
	
	
}

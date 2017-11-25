package mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Person2 {

	@Id
	private int id;
	private String name;
	@OneToMany(mappedBy="vehicleId")
	private Collection<Vehicle2> vehicle = new ArrayList<Vehicle2>();
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Collection<Vehicle2> getVehicle() {
		return vehicle;
	}
	public void setVehicle(Collection<Vehicle2> vehicle) {
		this.vehicle = vehicle;
	}
		
}

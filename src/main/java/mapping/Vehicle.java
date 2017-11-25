package mapping;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue
	private int id;
	private String name;
	//@ManyToOne
	@ManyToMany
	private Collection<Person> owner = new ArrayList<Person>();

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

	public Collection<Person> getOwner() {
		return owner;
	}

	public void setOwner(Collection<Person> owner) {
		this.owner = owner;
	}
	
	
}

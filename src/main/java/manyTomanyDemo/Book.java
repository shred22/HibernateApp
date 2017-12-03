package manyTomanyDemo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Book {
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy="org.hibernate.id.UUIDGenerator")
	UUID id;
	
	
	private String name;
	@ManyToMany(cascade = CascadeType.ALL)
	private Collection<Author> auth = new ArrayList<Author>();

	public Book() {
		super();
	}
	
	public Book(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}


	
	public Collection<Author> getAuth() {
		return auth;
	}

	public void setAuth(Collection<Author> auth) {
		this.auth = auth;
	}

	public UUID getId() {
		return id;
	}


	public void setId(UUID id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	
	
	
}

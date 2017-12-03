package manyTomanyDemo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {

	@Id
	private int auth_id;
	private String auth_Name;
	@ManyToMany(mappedBy = "auth")
	private Collection<Book> book = new ArrayList<Book>();
	public Author() {
		super();
	}
	public Author(int auth_id, String auth_Name) {
		super();
		this.auth_id = auth_id;
		this.auth_Name = auth_Name;
	}
	public int getAuth_id() {
		return auth_id;
	}
	public void setAuth_id(int auth_id) {
		this.auth_id = auth_id;
	}
	public String getAuth_Name() {
		return auth_Name;
	}
	public void setAuth_Name(String auth_Name) {
		this.auth_Name = auth_Name;
	}
	public Collection<Book> getBook() {
		return book;
	}
	public void setBook(Collection<Book> book) {
		this.book = book;
	}
	
	
}

package criteriaDemos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class League {

	@Id
	@TableGenerator(name="tableGen", initialValue=1, pkColumnName="PK")
	@GeneratedValue(generator="tableGen", strategy=GenerationType.TABLE)
	private int id;
	private String name;
	private String winnner;
	
	public League() {
		super();
	}
	public League(String name, String winner) {
		super();
		this.winnner = winner;
		this.name = name;
	}
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
	public String getWinnner() {
		return winnner;
	}
	public void setWinnner(String winnner) {
		this.winnner = winnner;
	}
	
}

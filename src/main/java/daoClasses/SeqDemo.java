package daoClasses;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class SeqDemo {

	@Id
	@SequenceGenerator(name="seq1", initialValue=10, allocationSize=30, sequenceName="HIB_SEQ")
	@GeneratedValue(generator="seq1",strategy=GenerationType.SEQUENCE)
	private int id;
	private String value;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
	
}

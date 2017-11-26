package embedableIdDemo;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class IDclass implements Serializable{

	private String name;
	private String rollNo;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
}

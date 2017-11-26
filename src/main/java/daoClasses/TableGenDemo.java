package daoClasses;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.TableGenerator;

@Entity
public class TableGenDemo {
	

	@Id
	@TableGenerator(name="table_gen", table="ID_TABLE", pkColumnName="ID", valueColumnName="NEXT_ID", initialValue=15 )
	@GeneratedValue(generator="table_gen", strategy=GenerationType.TABLE)
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

package embedableIdDemo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class EmbedableIdDemo {

	@Id
	private IDclass id;
	private String value;

	public IDclass getId() {
		return id;
	}

	public void setId(IDclass id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}

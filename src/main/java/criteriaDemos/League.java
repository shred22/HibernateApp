package criteriaDemos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.TableGenerator;

@Entity
public class League {

	@Id
	@TableGenerator(name="tableGen", initialValue=1, pkColumnName="PK")
	@GeneratedValue(generator="tableGen", strategy=GenerationType.TABLE)
	private int id;
	private String name;
	private String winnner;
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
	        name = "player_leagues",
	        joinColumns = { @JoinColumn(name = "id") }, 
	        inverseJoinColumns = { @JoinColumn(name = "playerId") })
	
	private Set<Player> players = new HashSet<>();
	
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
	public Set<Player> getPlayers() {
		return players;
	}
	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
	public String toString() {
		return this.name;
	}
}

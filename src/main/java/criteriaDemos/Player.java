package criteriaDemos;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Player {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int playerId;
	private String playerName;
	private String nationality;
	@ManyToMany(mappedBy="players",cascade=CascadeType.ALL)
	private Set<League> leagues = new HashSet<>();
	
	public Player() {
		super();
	}

	public Player( String playerName, String nationality) {
		super();
		this.playerName = playerName;
		this.nationality = nationality;
	}

	public int getPlayerId() {
		return playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public Set<League> getLeagues() {
		return leagues;
	}

	public void setLeagues(Set<League> leagues) {
		this.leagues = leagues;
	}
}

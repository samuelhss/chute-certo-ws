package bepid.ccerto.guess.domain;

import javax.persistence.*;

import bepid.ccerto.match.domain.Match;
import bepid.ccerto.user.domain.User;

@Entity
@Table(name = "GUESS")
public class Guess {
	
	private Long id;
	private User user;
	private Match match;
	private String scoreHome;
	private String scoreAway;
	
	@Id
	@GeneratedValue
	@Column(name = "SEQ_GUESS")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "SEQ_USER")
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	@ManyToOne(targetEntity = Match.class)
	@JoinColumn(name = "SEQ_MATCH")
	public Match getMatch() {
		return match;
	}
	
	public void setMatch(Match match) {
		this.match = match;
	}
	
	@Column(name = "SCORE_HOME")
	public String getScoreHome() {
		return scoreHome;
	}
	
	public void setScoreHome(String scoreHome) {
		this.scoreHome = scoreHome;
	}
	
	@Column(name = "SCORE_AWAY")
	public String getScoreAway() {
		return scoreAway;
	}
	
	public void setScoreAway(String scoreAway) {
		this.scoreAway = scoreAway;
	}
}

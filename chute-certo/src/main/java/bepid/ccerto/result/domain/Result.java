package bepid.ccerto.result.domain;

import javax.persistence.*;

import bepid.ccerto.match.domain.Match;

@Entity
@Table(name = "RESULT")
public class Result {
	
	private Match match;
	private String scoreHome;
	private String scoreAway;
	
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

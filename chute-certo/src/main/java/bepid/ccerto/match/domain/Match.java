package bepid.ccerto.match.domain;

import javax.persistence.*;

import bepid.ccerto.team.domain.Team;

@Entity
@Table(name = "MATCH")
public class Match {
	
	private Long id;
	private Team homeTeam;
	private Team awayTeam;
	
	@Id
	@Column(name = "SEQ_MATCH")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@ManyToOne(targetEntity = Team.class)
	@JoinColumn(name = "HOME_TEAM_ID")
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	
	@ManyToOne(targetEntity = Team.class)
	@JoinColumn(name = "AWAY_TEAM_ID")
	public Team getAwayTeam() {
		return awayTeam;
	}
	
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
}

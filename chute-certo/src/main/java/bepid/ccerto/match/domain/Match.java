package bepid.ccerto.match.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import bepid.ccerto.team.domain.Team;

@Entity
@Table(name = "SOCCER_MATCH")
public class Match {
	
	private Long id;
	private Team homeTeam;
	private Team awayTeam;
	private Calendar date;
	
	@Id
	@GeneratedValue
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
	
	@Column(name = "DATE")
	public Calendar getDate() {
		return date;
	}
	
	public void setDate(Calendar date) {
		this.date = date;
	}
}

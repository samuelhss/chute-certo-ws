package bepid.ccerto.match.domain;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import bepid.ccerto.result.domain.Result;
import bepid.ccerto.round.domain.Round;
import bepid.ccerto.team.domain.Team;
import bepid.ccerto.util.converter.FlagSimNaoConverter;

@Entity
@Table(name = "MATCHES")
public class Match {
	
	private Long id;
	private Team homeTeam;
	private Team awayTeam;
	private Calendar date;
	private Round round;
	private Result result;
	private Boolean special;
	
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

	@ManyToOne(targetEntity = Round.class)
	@JoinColumn(name = "SEQ_ROUND")
	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}

	@OneToOne(mappedBy = "match", targetEntity = Result.class)
	@JoinColumn(name = "SEQ_RESULT")
	public Result getResult() {
		return result;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	@Convert(converter = FlagSimNaoConverter.class)
	@Column(name = "FLG_SPECIAL", nullable = false, columnDefinition = "char default 'N'")
	public Boolean isSpecial() {
		return special == null ? false : special;
	}

	public void setSpecial(Boolean special) {
		this.special = special;
	}
}

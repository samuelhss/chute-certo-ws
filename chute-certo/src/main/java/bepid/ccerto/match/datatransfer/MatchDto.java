package bepid.ccerto.match.datatransfer;

import java.util.Calendar;

import bepid.ccerto.match.domain.Match;
import bepid.ccerto.team.datatransfer.TeamDto;

public class MatchDto {
	
	public Long id;
	public TeamDto homeTeam;
	public TeamDto awayTeam;
	public Calendar date;
	
	public MatchDto() {}
	
	public MatchDto(Match match) {
		this.id = match.getId();
		this.homeTeam = new TeamDto(match.getHomeTeam());
		this.awayTeam = new TeamDto(match.getAwayTeam());
		this.date = match.getDate();
	}

	public Match convertToEntity() {
		Match match = new Match();
		match.setId(id);
		match.setHomeTeam(homeTeam.convertToEntity());
		match.setAwayTeam(awayTeam.convertToEntity());
		match.setDate(date);
		
		return match;
	}

}

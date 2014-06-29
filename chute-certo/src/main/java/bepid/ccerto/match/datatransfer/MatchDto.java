package bepid.ccerto.match.datatransfer;

import java.util.Calendar;

import bepid.ccerto.match.domain.Match;
import bepid.ccerto.team.datatransfer.TeamDto;

public class MatchDto {
	
	public Long id;
	public TeamDto homeTeam;
	public TeamDto awayTeam;
	public Calendar date;
	public Boolean hasResult;
	
	public MatchDto() {}
	
	public MatchDto(Match match) {
		id = match.getId();
		homeTeam = new TeamDto(match.getHomeTeam());
		awayTeam = new TeamDto(match.getAwayTeam());
		date = match.getDate();
		hasResult = match.getResult() != null;
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

package bepid.ccerto.match.datatransfer;

import java.util.Calendar;

import bepid.ccerto.match.domain.Match;
import bepid.ccerto.result.datatransfer.ResultDto;
import bepid.ccerto.team.datatransfer.TeamDto;

public class MatchDto implements Comparable<MatchDto>{
	
	public Long id;
	public TeamDto homeTeam;
	public TeamDto awayTeam;
	public Calendar date;
	public Long idRound;
	public ResultDto result;
	
	public MatchDto() {}
	
	public MatchDto(Match match) {
		id = match.getId();
		homeTeam = new TeamDto(match.getHomeTeam());
		awayTeam = new TeamDto(match.getAwayTeam());
		date = match.getDate();
		idRound = match.getRound().getId();
		result = match.getResult() != null ? new ResultDto(match.getResult()) : null;
	}

	public Match convertToEntity() {
		Match match = new Match();
		match.setId(id);
		match.setHomeTeam(homeTeam.convertToEntity());
		match.setAwayTeam(awayTeam.convertToEntity());
		match.setDate(date);
		
		return match;
	}

	@Override
	public int compareTo(MatchDto other) {
		
		if (this.date.compareTo(other.date) == 0) {
			return this.id.compareTo(other.id);
		}
		
		return this.date.compareTo(other.date);
	}

}

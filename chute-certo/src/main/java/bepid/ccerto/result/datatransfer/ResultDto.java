package bepid.ccerto.result.datatransfer;

import bepid.ccerto.result.domain.Result;

public class ResultDto {
	
	public Long id;
	public Long idMatch;
	public String scoreHome;
	public String scoreAway;
	public String winner;
	
	public ResultDto() {}

	public ResultDto(Result result) {
		id = result.getId();
		idMatch = result.getMatch().getId();
		scoreHome = result.getScoreHome();
		scoreAway = result.getScoreAway();
		winner = Integer.parseInt(scoreHome) > Integer.parseInt(scoreAway) ? "home" : 
					Integer.parseInt(scoreAway) > Integer.parseInt(scoreHome) ? "away" : "none";
	}

	public Result convertToEntity() {
		Result result = new Result();
		result.setId(id);
		result.setScoreHome(scoreHome);
		result.setScoreAway(scoreAway);
		
		return result;
	}

}

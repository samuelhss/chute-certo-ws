package bepid.ccerto.guess.datatransfer;

import bepid.ccerto.guess.domain.Guess;
import bepid.ccerto.match.datatransfer.MatchDto;
import bepid.ccerto.user.datatransfer.UserDto;

public class GuessDto {
	
	public Long id;
	public MatchDto match;
	public UserDto user;
	public String scoreHome;
	public String scoreAway;

	public GuessDto() {};
	
	public GuessDto(Guess guess) {
		this.id = guess.getId();
		this.match = new MatchDto(guess.getMatch());
		this.user = new UserDto(guess.getUser());
		this.scoreHome = guess.getScoreHome();
		this.scoreAway = guess.getScoreAway();		
	}
	
	public Guess convertToEntity() {
		Guess guess = new Guess();
		guess.setId(id);
		guess.setMatch(match.convertToEntity());
		guess.setUser(user.convertToEntity());
		guess.setScoreHome(scoreHome);
		guess.setScoreAway(scoreAway);
		
		return guess;
	}

}

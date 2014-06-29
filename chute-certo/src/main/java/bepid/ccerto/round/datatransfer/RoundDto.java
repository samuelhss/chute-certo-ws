package bepid.ccerto.round.datatransfer;

import bepid.ccerto.championship.datatransfer.ChampionshipDto;
import bepid.ccerto.round.domain.Round;

public class RoundDto {
	
	public Long id;
	public String description;
	public ChampionshipDto championship;
	
	public RoundDto() {}
	
	public RoundDto(Round round) {
		id = round.getId();
		description = round.getDescription();
		championship = new ChampionshipDto(round.getChampionship());
	}
	
	public Round convertToEntity() {
		Round round = new Round();
		round.setId(id);
		round.setDescription(description);
		round.setChampionship(championship.convertToEntity());
		
		return round;
	}

}

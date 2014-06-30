package bepid.ccerto.championship.datatransfer;

import bepid.ccerto.championship.domain.Championship;

public class ChampionshipDto {
	
	public Long id;
	public String description;
	
	public ChampionshipDto() {}
	
	public ChampionshipDto(Championship championship) {
		id = championship.getId();
		description = championship.getDescription();
	}
	
	public Championship convertToEntity() {
		Championship championship = new Championship();
		championship.setId(id);
		championship.setDescription(description);
		
		return championship;
	}

}

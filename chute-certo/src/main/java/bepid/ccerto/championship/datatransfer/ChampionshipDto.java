package bepid.ccerto.championship.datatransfer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bepid.ccerto.championship.domain.Championship;
import bepid.ccerto.round.datatransfer.RoundDto;
import bepid.ccerto.round.domain.Round;

public class ChampionshipDto {
	
	public Long id;
	public String description;
	public List<RoundDto> rounds;
	
	public ChampionshipDto() {}
	
	public ChampionshipDto(Championship championship) {
		id = championship.getId();
		description = championship.getDescription();
		if (championship.getRounds() != null) {
			List<RoundDto> listaDto = new ArrayList<RoundDto>();
			for (Round round : championship.getRounds()) {
				listaDto.add(new RoundDto(round));
			}
			Collections.sort(listaDto);
			rounds = listaDto;
		}
	}
	
	public Championship convertToEntity() {
		Championship championship = new Championship();
		championship.setId(id);
		championship.setDescription(description);
		
		return championship;
	}

}

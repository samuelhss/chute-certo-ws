package bepid.ccerto.round.datatransfer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import bepid.ccerto.match.datatransfer.MatchDto;
import bepid.ccerto.match.domain.Match;
import bepid.ccerto.round.domain.Round;

public class RoundDto implements Comparable<RoundDto>{
	
	public Long id;
	public String description;
	public Long idChampionship;
	public List<MatchDto> matches;
	
	public RoundDto() {}
	
	public RoundDto(Round round) {
		id = round.getId();
		description = round.getDescription();
		idChampionship = round.getChampionship().getId();
		if (round.getMatches() != null) {
			List<MatchDto> listaDto = new ArrayList<MatchDto>();
			for (Match match : round.getMatches()) {
				listaDto.add(new MatchDto(match));
			}
			Collections.sort(listaDto);
			matches = listaDto;
		}
	}
	
	public Round convertToEntity() {
		Round round = new Round();
		round.setId(id);
		round.setDescription(description);		
		return round;
	}

	@Override
	public int compareTo(RoundDto other) {
		return other.id.compareTo(this.id);
	}

}

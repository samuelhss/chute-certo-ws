package bepid.ccerto.team.datatransfer;

import bepid.ccerto.team.domain.Team;

public class TeamDto {
	
	public String name;
	public String sigla;
	
	public TeamDto() {}
	
	public TeamDto(Team team) {
		this.name = team.getName();
		this.sigla = team.getSigla();
	}

}

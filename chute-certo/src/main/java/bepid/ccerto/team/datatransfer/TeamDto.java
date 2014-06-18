package bepid.ccerto.team.datatransfer;

import bepid.ccerto.team.domain.Team;

public class TeamDto {
	
	public Long id;
	public String name;
	public String sigla;
	
	public TeamDto() {}
	
	public TeamDto(Team team) {
		this.id = team.getId();
		this.name = team.getName();
		this.sigla = team.getSigla();
	}

	public Team convertToEntity() {
		Team team = new Team();
		team.setId(id);
		team.setName(name);
		team.setSigla(sigla);
		
		return team;
	}

}

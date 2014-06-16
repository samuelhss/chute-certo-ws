package bepid.ccerto.team.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.team.datatransfer.TeamDto;
import bepid.ccerto.team.domain.Team;
import bepid.ccerto.team.repository.TeamRepository;

@Controller
@RequestMapping(value = "/team")
public class TeamService {
	
	@Autowired
	TeamRepository teamRepository;
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Team save(@RequestBody TeamDto dto) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TeamDto> list() {
		
		List<Team> lista = teamRepository.findAll();
		List<TeamDto> listaDto = new ArrayList<TeamDto>();
		
		for (Team team : lista) {
			listaDto.add(new TeamDto(team));
		}
		
		return listaDto;
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable Long id) {
		
	}

}

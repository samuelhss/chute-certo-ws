package bepid.ccerto.team.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.team.datatransfer.TeamDto;
import bepid.ccerto.team.domain.Team;

@Controller
@RequestMapping(value = "/team")
public class TeamService {
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Team save(@RequestBody TeamDto dto) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TeamDto> list() {
		
		return null;
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable Long id) {
		
	}

}

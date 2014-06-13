package bepid.ccerto.match.service;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.match.datatransfer.MatchDto;
import bepid.ccerto.match.domain.Match;

@Controller
@RequestMapping(value = "/match")
public class MatchService {
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Match save(@RequestBody MatchDto dto) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<MatchDto> list() {
		
		return null;
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable Long id) {
		
	}

}

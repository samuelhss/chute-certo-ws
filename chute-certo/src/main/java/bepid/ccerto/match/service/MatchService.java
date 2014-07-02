package bepid.ccerto.match.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.match.datatransfer.MatchDto;
import bepid.ccerto.match.domain.Match;
import bepid.ccerto.match.repository.MatchRepository;
import bepid.ccerto.round.repository.RoundRepository;

@Controller
@RequestMapping(value = "/match")
public class MatchService {
	
	@Autowired
	MatchRepository matchRepository;
	
	@Autowired
	RoundRepository roundRepository;
	
	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public MatchDto save(@RequestBody MatchDto dto) {
		Match match = dto.convertToEntity();
		match.setResult(null);
		match.setRound(roundRepository.findOne(dto.idRound));
		return new MatchDto(matchRepository.save(match));
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<MatchDto> list() {
		List<Match> lista = matchRepository.findAll();
		List<MatchDto> listaDto = new ArrayList<MatchDto>();
		
		for (Match match : lista) {
			listaDto.add(new MatchDto(match));
		}
		
		return listaDto;
	}
	
	@ResponseBody
	@RequestMapping(value = "/specials", method = RequestMethod.GET)
	public List<MatchDto> specials() {
		List<Match> lista = matchRepository.getSpecialMatches();
		List<MatchDto> listaDto = new ArrayList<MatchDto>();
		
		for (Match match : lista) {
			listaDto.add(new MatchDto(match));
		}
		
		return listaDto;
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable Long id) {
		
	}

}

package bepid.ccerto.round.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.championship.repository.ChampionshipRepository;
import bepid.ccerto.match.datatransfer.MatchDto;
import bepid.ccerto.match.domain.Match;
import bepid.ccerto.round.datatransfer.RoundDto;
import bepid.ccerto.round.domain.Round;
import bepid.ccerto.round.repository.RoundRepository;

@Controller
@RequestMapping("/round")
public class RoundService {

	@Autowired
	RoundRepository roundRepository;
	
	@Autowired
	ChampionshipRepository championshipRepository;
	
	@ResponseBody
	@RequestMapping("/save")
	public RoundDto save(@RequestBody RoundDto dto) {
		Round round = dto.convertToEntity();
		round.setChampionship(championshipRepository.findOne(dto.idChampionship));
		return new RoundDto(roundRepository.save(round));
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public List<RoundDto> list() {
		List<Round> lista = roundRepository.findAll();
		List<RoundDto> listaDto = new ArrayList<RoundDto>();
		
		for (Round round : lista) {
			listaDto.add(new RoundDto(round));
		}
		
		return listaDto;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/matches", method = RequestMethod.GET)
	public List<MatchDto> matches(@RequestParam Long id) {
		Set<Match> lista = roundRepository.findOne(id).getMatches();
		List<MatchDto> listaDto = new ArrayList<MatchDto>();
		
		for (Match match : lista) {
			listaDto.add(new MatchDto(match));
		}
		
		return listaDto;
	}
}

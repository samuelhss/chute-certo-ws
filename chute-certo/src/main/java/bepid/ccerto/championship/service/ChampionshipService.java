package bepid.ccerto.championship.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.championship.datatransfer.ChampionshipDto;
import bepid.ccerto.championship.domain.Championship;
import bepid.ccerto.championship.repository.ChampionshipRepository;
import bepid.ccerto.round.datatransfer.RoundDto;
import bepid.ccerto.round.domain.Round;

@Transactional
@Controller
@RequestMapping("/championship")
public class ChampionshipService {

	@Autowired
	ChampionshipRepository championshipRepository;
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ChampionshipDto save(@RequestBody ChampionshipDto dto) {
		return new ChampionshipDto(championshipRepository.save(dto.convertToEntity()));
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<ChampionshipDto> list() {
		List<Championship> lista = championshipRepository.findAll();
		List<ChampionshipDto> listaDto = new ArrayList<ChampionshipDto>();
		
		for (Championship championship : lista) {
			listaDto.add(new ChampionshipDto(championship));
		}
		
		return listaDto;
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ChampionshipDto get(@PathVariable Long id) {
		return new ChampionshipDto(championshipRepository.findOne(id));
	}
	
	@ResponseBody
	@RequestMapping(value = "/{id}/rounds", method = RequestMethod.GET)
	public List<RoundDto> rounds(@PathVariable Long id) {
		Set<Round> lista = championshipRepository.findOne(id).getRounds();
		List<RoundDto> listaDto = new ArrayList<RoundDto>();
		
		for (Round round : lista) {
			listaDto.add(new RoundDto(round));
		}
		
		return listaDto;
	}
}

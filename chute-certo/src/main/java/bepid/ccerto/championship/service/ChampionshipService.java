package bepid.ccerto.championship.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.championship.datatransfer.ChampionshipDto;
import bepid.ccerto.championship.domain.Championship;
import bepid.ccerto.championship.repository.ChampionshipRepository;

@Transactional
@Controller
@RequestMapping("/championship")
public class ChampionshipService {

	@Autowired
	ChampionshipRepository championshipRepository;
	
	@ResponseBody
	@RequestMapping("/save")
	public ChampionshipDto save(@RequestBody ChampionshipDto dto) {
		return new ChampionshipDto(championshipRepository.save(dto.convertToEntity()));
	}
	
	@ResponseBody
	@RequestMapping("/list")
	public List<ChampionshipDto> list() {
		List<Championship> lista = championshipRepository.findAll();
		List<ChampionshipDto> listaDto = new ArrayList<ChampionshipDto>();
		
		for (Championship championship : lista) {
			listaDto.add(new ChampionshipDto(championship));
		}
		
		return listaDto;
	}
}

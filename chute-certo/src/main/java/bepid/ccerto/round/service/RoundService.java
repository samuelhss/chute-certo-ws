package bepid.ccerto.round.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.round.datatransfer.RoundDto;
import bepid.ccerto.round.domain.Round;
import bepid.ccerto.round.repository.RoundRepository;

@Controller
@RequestMapping("/round")
public class RoundService {

	@Autowired
	RoundRepository roundRepository;
	
	@ResponseBody
	@RequestMapping("/save")
	public RoundDto save(@RequestBody RoundDto dto) {
		return new RoundDto(roundRepository.save(dto.convertToEntity()));
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
}

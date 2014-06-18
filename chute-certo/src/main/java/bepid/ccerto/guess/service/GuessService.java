package bepid.ccerto.guess.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.guess.datatransfer.GuessDto;
import bepid.ccerto.guess.domain.Guess;
import bepid.ccerto.guess.repository.GuessRepository;

@Controller
@RequestMapping("/guess")
public class GuessService {

	@Autowired
	GuessRepository guessRepository;
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public GuessDto save(@RequestBody GuessDto dto) {	
		return new GuessDto(guessRepository.save(dto.convertToEntity()));
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<GuessDto> list() {
		List<Guess> lista = guessRepository.findAll();
		List<GuessDto> listaDto = new ArrayList<GuessDto>();
		
		for (Guess guess : lista) {
			listaDto.add(new GuessDto(guess));
		}
		
		return listaDto;
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable Long id) {
		
	}
}

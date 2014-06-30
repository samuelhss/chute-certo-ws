package bepid.ccerto.result.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.result.datatransfer.ResultDto;
import bepid.ccerto.result.domain.Result;
import bepid.ccerto.result.repository.ResultRepository;

@Controller
@RequestMapping("/result")
public class ResultService {
	
	private static final Logger logger = Logger.getLogger(ResultService.class);
	
	@Autowired
	ResultRepository resultRepository;
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ResultDto save(@RequestBody ResultDto dto) {
		
		return new ResultDto(resultRepository.save(dto.convertToEntity()));
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<ResultDto> list() {
		List<Result> lista = resultRepository.findAll();
		List<ResultDto> listaDto = new ArrayList<ResultDto>();
		
		for (Result result : lista) {
			listaDto.add(new ResultDto(result));
		}
		
		return listaDto;
	}
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable Long id) {
		resultRepository.delete(id);
	}

}

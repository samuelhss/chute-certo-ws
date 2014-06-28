package bepid.ccerto.user.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bepid.ccerto.user.datatransfer.UserDto;
import bepid.ccerto.user.domain.User;
import bepid.ccerto.user.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	//private static final Logger logger = Logger.getLogger(UserService.class);
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public UserDto save(@RequestBody UserDto dto) {
		return new UserDto(userRepository.save(dto.convertToEntity()));
	}
	
	@ResponseBody
	@RequestMapping(value = "/ranking", method = RequestMethod.GET)
	public List<UserDto> ranking() {
		List<User> lista = userRepository.findAll();
		List<UserDto> listaDto = new ArrayList<UserDto>();
		
		/*
		 * 
		 * 
		 * 
		 * 
		 * */
		
		
		for (User user : lista) {
			listaDto.add(new UserDto(user));
		}
		
		Collections.sort(listaDto);
		
		return listaDto;
	}
	
}

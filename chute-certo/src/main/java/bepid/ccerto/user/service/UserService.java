package bepid.ccerto.user.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bepid.ccerto.user.datatransfer.UserDto;
import bepid.ccerto.user.repository.UserRepository;

@Controller
@RequestMapping("/user")
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public UserDto save(@RequestBody UserDto dto) {
		logger.info("Requisicao recebida: " + dto.nickname);
		return new UserDto(userRepository.save(dto.convertToEntity()));
	}
	
}

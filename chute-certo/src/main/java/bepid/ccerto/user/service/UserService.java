package bepid.ccerto.user.service;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import bepid.ccerto.user.datatransfer.UserDto;

@Controller
@RequestMapping("/user")
public class UserService {
	
	private static final Logger logger = Logger.getLogger(UserService.class);
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public void save(@RequestBody UserDto dto) {
		System.out.println("Nickname: " + dto.nickname);
		logger.info("Requisicao recebida: " + dto.nickname);
	}
	
}

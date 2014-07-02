package bepid.ccerto.user.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.notnoop.apns.APNS;
import com.notnoop.apns.ApnsService;
import com.notnoop.apns.PayloadBuilder;

import bepid.ccerto.user.datatransfer.UserDto;
import bepid.ccerto.user.domain.User;
import bepid.ccerto.user.repository.UserRepository;
import bepid.ccerto.util.utils.Paths;

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
	@RequestMapping(value = "/notificate/all")
	public String pushAll(@RequestBody String message){
		
		List<User> allUsers = userRepository.findAll();
		
		ApnsService service =
			    APNS.newService()
			    .withCert(Paths.LOCAL_FILES
		       		+ File.separator + "push-notifications"
		        		+ File.separator + "iphone_dev.p12", "bepid105886")
			    .withSandboxDestination()
					    .build();
		service.start();
				
		PayloadBuilder payloadBuilder = APNS.newPayload();
		payloadBuilder = payloadBuilder.badge(1)
				.alertBody(message)
				.sound("Default");	
		
		if (payloadBuilder.isTooLong()) {
			payloadBuilder = payloadBuilder.shrinkBody();
		}
		
		for (User user : allUsers) {
			service.push(user.getToken(), payloadBuilder.build());
		}
		
		return "Notifications sent!";
	}
	
	@ResponseBody
	@RequestMapping(value = "/ranking", method = RequestMethod.GET)
	public List<UserDto> ranking() {
		List<User> lista = userRepository.findAll();
		List<UserDto> listaDto = new ArrayList<UserDto>();		
		
		for (User user : lista) {
			listaDto.add(new UserDto(user));
		}
		
		Collections.sort(listaDto);
		
		return listaDto;
	}
	
}

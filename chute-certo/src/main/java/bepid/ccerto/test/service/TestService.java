package bepid.ccerto.test.service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/teste")
public class TestService {

	@ResponseBody
	@RequestMapping(value = "/first", method = RequestMethod.GET)
	public Pessoa firstService() {
		return new Pessoa("Samuel");
	}
	
	
}

package bepid.ccerto.team.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import bepid.ccerto.team.datatransfer.TeamDto;
import bepid.ccerto.team.domain.Team;
import bepid.ccerto.team.repository.TeamRepository;

@Controller
@RequestMapping(value = "/team")
public class TeamService {
	
	@Autowired
	TeamRepository teamRepository;
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public Team save(@RequestBody TeamDto dto) {
		
		return null;
	}
	
	@ResponseBody
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public List<TeamDto> list() {
		List<Team> lista = teamRepository.findAll();
		List<TeamDto> listaDto = new ArrayList<TeamDto>();
		
		for (Team team : lista) {
			listaDto.add(new TeamDto(team));
		}
		
		return listaDto;
	}
	
	@RequestMapping(value="/photo", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
                byte[] bytes = file.getBytes();
                BufferedOutputStream stream =
                        new BufferedOutputStream(new FileOutputStream(new File(name + "-uploaded")));
                stream.write(bytes);
                stream.close();
                return "You successfully uploaded " + name + " into " + name + "-uploaded !";
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name + " because the file was empty.";
        }
    }
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable Long id) {
		
	}

}

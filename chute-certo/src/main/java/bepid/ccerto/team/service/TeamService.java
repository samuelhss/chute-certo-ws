package bepid.ccerto.team.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
import bepid.ccerto.util.utils.Paths;

@Controller
@RequestMapping(value = "/team")
public class TeamService {
	
	private static final Logger logger = Logger.getLogger(TeamService.class);
	
	@Autowired
	ServletContext servletContext;
	
	@Autowired
	TeamRepository teamRepository;
	
	@ResponseBody
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public TeamDto save(@RequestBody TeamDto dto) {
		
		return new TeamDto(teamRepository.save(dto.convertToEntity()));
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
	
	@RequestMapping(value="/flag/upload", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("name") String name,
            @RequestParam("file") MultipartFile file){
		
		if (!file.isEmpty()) {
            try {
            	
                byte[] bytes = file.getBytes();
                
                //mudar para JELASTIC_FILES
                File dir = new File(Paths.LOCAL_FILES
                		+ File.separator + "images" + File.separator + "flags");
                if (!dir.exists())
                    dir.mkdirs();
 
                File serverFile = new File(dir.getAbsolutePath()
                        + File.separator + name + ".png");
                BufferedOutputStream stream = new BufferedOutputStream(
                        new FileOutputStream(serverFile));
                stream.write(bytes);
                stream.close();
 
                logger.info("Server File Location="
                        + serverFile.getAbsolutePath());
 
                return "You successfully uploaded file=" + name;
            } catch (Exception e) {
                return "You failed to upload " + name + " => " + e.getMessage();
            }
        } else {
            return "You failed to upload " + name
                    + " because the file was empty.";
        }
    }
	
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.DELETE)
	public void remove(@PathVariable Long id) {
		teamRepository.delete(id);
	}
	
	@RequestMapping("/flag/{sigla}")
	public ResponseEntity<byte[]> flag(@PathVariable String sigla) throws IOException {
	    
		File dir = new File(Paths.LOCAL_FILES
        		+ File.separator + "images" + File.separator + "flags");
        File serverFile = new File(dir.getAbsolutePath()
                + File.separator + sigla.toUpperCase() + ".png");
        
        FileInputStream filein = new FileInputStream(serverFile);

	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_PNG);

	    return new ResponseEntity<byte[]>(IOUtils.toByteArray(filein), headers, HttpStatus.CREATED);
	}
	
	@RequestMapping("/choice/{sigla}")
	public ResponseEntity<byte[]> image(@PathVariable String sigla) throws IOException {
	    
		File dir = new File(Paths.LOCAL_FILES
        		+ File.separator + "images" + File.separator + "choices_flags");
        File serverFile = new File(dir.getAbsolutePath()
                + File.separator + sigla.toUpperCase() + ".png");
        
        FileInputStream filein = new FileInputStream(serverFile);

	    final HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.IMAGE_PNG);

	    return new ResponseEntity<byte[]>(IOUtils.toByteArray(filein), headers, HttpStatus.CREATED);
	}

}

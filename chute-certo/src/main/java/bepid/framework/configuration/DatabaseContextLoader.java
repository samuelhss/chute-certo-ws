package bepid.framework.configuration;

import javax.servlet.ServletContextEvent;

import org.springframework.web.context.ContextLoaderListener;

import bepid.ccerto.team.repository.TeamRepository;

public class DatabaseContextLoader extends ContextLoaderListener {
	
	@Override
	public void contextInitialized(ServletContextEvent event) {
		super.contextInitialized(event);
		
		final TeamRepository teamRepository = getCurrentWebApplicationContext().getBean(TeamRepository.class);
		
		System.out.println("Iniciei!!!!!!!!!!!!");
	}

}

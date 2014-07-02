package bepid.ccerto.match.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class MatchRepositoryImpl implements MatchRepositoryCustom {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
}

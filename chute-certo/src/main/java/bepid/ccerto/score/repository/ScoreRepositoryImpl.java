package bepid.ccerto.score.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import bepid.ccerto.user.domain.User;

public class ScoreRepositoryImpl implements ScoreRepositoryCustom {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public Long getTotal(User user) {
		String sql = "SELECT SUM(POINTS) FROM SCORE score, " +
						"GUESS guess, USER user " +
					"WHERE score.SEQ_GUESS = guess.SEQ_GUESS " +
						"AND guess.SEQ_USER = user.SEQ_USER " +
						"AND user.SEQ_USER = " + user.getId();
		
		Long total = jdbcTemplate.queryForObject(sql, Long.class);
		
		total = total == null ? 0 : total;
		
		if (user.isFacebookConnected()) total += 200;
		else total += 100;
		
		return total;
	}

}

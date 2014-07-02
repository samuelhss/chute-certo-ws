package bepid.ccerto.match.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import bepid.ccerto.match.domain.Match;

public interface MatchRepository extends JpaRepository<Match, Long>, MatchRepositoryCustom {
	
	@Query("SELECT m FROM Match m WHERE m.special = 'S'")
    public List<Match> getSpecialMatches();

}

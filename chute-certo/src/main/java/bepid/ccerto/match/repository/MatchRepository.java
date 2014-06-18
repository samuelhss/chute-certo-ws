package bepid.ccerto.match.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bepid.ccerto.match.domain.Match;

public interface MatchRepository extends JpaRepository<Match, Long> {

}

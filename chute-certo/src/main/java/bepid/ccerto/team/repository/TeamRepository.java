package bepid.ccerto.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bepid.ccerto.team.domain.Team;

public interface TeamRepository extends JpaRepository<Team, Long>{

}

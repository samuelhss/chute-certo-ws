package bepid.ccerto.championship.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bepid.ccerto.championship.domain.Championship;

public interface ChampionshipRepository extends JpaRepository<Championship, Long> {

}

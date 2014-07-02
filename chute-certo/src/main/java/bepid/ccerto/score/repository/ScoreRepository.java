package bepid.ccerto.score.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bepid.ccerto.score.domain.Score;

public interface ScoreRepository extends JpaRepository<Score, Long>, ScoreRepositoryCustom {

}

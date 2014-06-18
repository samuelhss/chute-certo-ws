package bepid.ccerto.guess.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bepid.ccerto.guess.domain.Guess;

public interface GuessRepository extends JpaRepository<Guess, Long> {

}

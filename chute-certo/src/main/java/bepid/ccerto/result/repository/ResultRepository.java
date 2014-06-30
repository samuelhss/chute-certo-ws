package bepid.ccerto.result.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bepid.ccerto.result.domain.Result;

public interface ResultRepository extends JpaRepository<Result, Long> {

}

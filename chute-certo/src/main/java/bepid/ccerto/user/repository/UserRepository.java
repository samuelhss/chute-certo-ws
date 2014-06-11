package bepid.ccerto.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bepid.ccerto.user.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}

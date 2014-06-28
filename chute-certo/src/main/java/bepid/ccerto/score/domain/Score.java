package bepid.ccerto.score.domain;

import javax.persistence.*;

import bepid.ccerto.guess.domain.Guess;

@Entity
@Table(name = "SCORE")
public class Score {
	
	private Long id;
	private Guess guess;
	private Long points;
	
	@Id
	@GeneratedValue
	@Column(name = "SEQ_SCORE")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToOne
	@JoinColumn(name = "SEQ_GUESS")
	public Guess getGuess() {
		return guess;
	}
	
	public void setGuess(Guess guess) {
		this.guess = guess;
	}
	
	@Column(name = "POINTS")
	public Long getPoints() {
		return points;
	}
	
	public void setPoints(Long points) {
		this.points = points;
	}
}

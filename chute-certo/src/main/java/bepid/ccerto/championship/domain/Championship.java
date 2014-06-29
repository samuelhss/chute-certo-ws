package bepid.ccerto.championship.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import bepid.ccerto.round.domain.Round;

@Entity
@Table(name = "CHAMPIONSHIP")
public class Championship {
	
	private Long id;
	private String description;
	private Set<Round> rounds;
	
	@Id
	@GeneratedValue
	@Column(name = "SEQ_CHAMPIONSHIP")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "DSC_CHAMPIONSHIP")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(mappedBy = "championship", cascade = CascadeType.ALL)
	public Set<Round> getRounds() {
		return rounds;
	}
	
	public void setRounds(Set<Round> rounds) {
		this.rounds = rounds;
	}
}

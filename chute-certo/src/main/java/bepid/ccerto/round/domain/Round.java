package bepid.ccerto.round.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import bepid.ccerto.championship.domain.Championship;
import bepid.ccerto.match.domain.Match;

@Entity
@Table(name = "ROUND")
public class Round {
	
	private Long id;
	private String description;
	private Championship championship;
	private Set<Match> matches;
	
	@Id
	@GeneratedValue
	@Column(name = "SEQ_ROUND")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "DSC_ROUND")
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne(targetEntity = Championship.class)
	@JoinColumn(name = "SEQ_CHAMPIONSHIP")
	public Championship getChampionship() {
		return championship;
	}

	public void setChampionship(Championship championship) {
		this.championship = championship;
	}

	@OneToMany(mappedBy = "round", cascade = CascadeType.ALL)
	public Set<Match> getMatches() {
		return matches;
	}

	public void setMatches(Set<Match> matches) {
		this.matches = matches;
	}

}

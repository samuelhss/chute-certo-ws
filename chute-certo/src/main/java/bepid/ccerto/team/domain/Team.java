package bepid.ccerto.team.domain;

import javax.persistence.*;

@Entity
@Table(name = "TEAM")
public class Team {
	
	private Long id;
	private String sigla;
	private String name;
	
	@Id
	@GeneratedValue
	@Column(name = "SEQ_TEAM")
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "SIG_TEAM")
	public String getSigla() {
		return sigla;
	}
	
	public void setSigla(String sigla) {
		this.sigla = sigla;
	}
	
	@Column(name = "DSC_TEAM")
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	

}

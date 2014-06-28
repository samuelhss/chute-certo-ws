package bepid.ccerto.championship.domain;

import javax.persistence.*;

@Entity
@Table(name = "CHAMPIONSHIP")
public class Championship {
	
	private Long id;
	private String description;
	
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
}

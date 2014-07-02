package bepid.ccerto.user.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import bepid.ccerto.guess.domain.Guess;
import bepid.ccerto.util.converter.FlagGenderConverter;
import bepid.ccerto.util.converter.FlagSimNaoConverter;

@Entity
@Table(name = "USER")
public class User {
	
	private Long id;
	private String nickname;
	private String email;
	private Gender gender;
	private Boolean facebookConnected;
	private String token;
	private List<Guess> shots;
	
	@Id
	@GeneratedValue
	@Column(name = "SEQ_USER")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "NICKNAME")
	public String getNickname() {
		return nickname;
	}
	
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	@Column(name = "EMAIL", unique = true)
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name = "FLG_SEXO")
	@Convert(converter = FlagGenderConverter.class)
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	@Column(name = "FLG_FACEBOOK")
	@Convert(converter = FlagSimNaoConverter.class)
	public Boolean isFacebookConnected() {
		return facebookConnected;
	}
	
	public void setFacebookConnected(Boolean facebookConnected) {
		this.facebookConnected = facebookConnected;
	}

	@Column(name = "DEVICE_TOKEN")
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	public List<Guess> getShots() {
		return shots;
	}

	public void setShots(List<Guess> shots) {
		this.shots = shots;
	}
}

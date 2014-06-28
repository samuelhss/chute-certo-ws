package bepid.ccerto.user.domain;

import javax.persistence.*;

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
	
	@Column(name = "EMAIL")
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
}

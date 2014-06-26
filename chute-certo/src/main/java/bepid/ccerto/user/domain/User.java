package bepid.ccerto.user.domain;

import javax.persistence.*;

import bepid.ccerto.util.converter.FlagGenderConverter;

@Entity
@Table(name = "USER")
public class User {
	
	private Long id;
	private String nickname;
	private String email;
	private Gender gender;
	private String photo;
	private Long points;
	private Boolean isFacebookConnected;
	
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
	
	@Column(name = "ENCODED_PHOTO")
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	@Column(name = "POINTS")
	public Long getPoints() {
		return points;
	}
	
	public void setPoints(Long points) {
		this.points = points;
	}
}

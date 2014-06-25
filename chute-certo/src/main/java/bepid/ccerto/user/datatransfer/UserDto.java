package bepid.ccerto.user.datatransfer;

import bepid.ccerto.user.domain.Gender;
import bepid.ccerto.user.domain.User;

public class UserDto {
	
	public Long id;
	public String nickname;
	public String gender;
	public String email;
	public Boolean facebookConnected;
	
	UserDto() {}
	
	public UserDto(User user) {
		this.nickname = user.getNickname();
		this.email = user.getEmail();
		this.gender = user.getGender().getId();
		this.id = user.getId();
	}
	
	public User convertToEntity() {
		User user = new User();
		user.setNickname(nickname);
		user.setEmail(email);
		user.setGender(Gender.getById(gender));
		user.setId(id);
		
		return user;
	}

}

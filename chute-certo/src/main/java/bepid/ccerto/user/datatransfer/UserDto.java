package bepid.ccerto.user.datatransfer;

import bepid.ccerto.user.domain.Gender;
import bepid.ccerto.user.domain.User;

public class UserDto implements Comparable<UserDto> {
	
	public Long id;
	public String nickname;
	public String gender;
	public String email;
	public Boolean facebookConnected;
	public Long points;
	public String token;
	
	UserDto() {
		points = 0L;
	}
	
	public UserDto(User user) {
		nickname = user.getNickname();
		email = user.getEmail();
		gender = user.getGender().getId();
		id = user.getId();
		facebookConnected = user.isFacebookConnected();
		token = user.getToken();
		points = 0L;
	}
	
	public User convertToEntity() {
		User user = new User();
		user.setNickname(nickname);
		user.setEmail(email);
		user.setGender(Gender.getById(gender));
		user.setId(id);
		user.setFacebookConnected(facebookConnected);
		user.setToken(token);

		return user;
	}

	@Override
	public int compareTo(UserDto other) {
		return other.points.compareTo(this.points);
	}

}

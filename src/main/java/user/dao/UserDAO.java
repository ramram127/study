package user.dao;

import user.vo.UserVO;

public interface UserDAO {
	public UserVO login (String userid , String userpwd);
}

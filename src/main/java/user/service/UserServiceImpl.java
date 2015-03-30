package user.service;

import user.dao.UserDAO;
import user.vo.UserVO;

public class UserServiceImpl implements UserService{
	
	UserDAO userDao = null;
	
	//set,get을 하여 노출
	public UserDAO getUserDao() {
		return userDao;
	}

	public UserServiceImpl(UserDAO userDao) {
		super();
		this.userDao = userDao;
	}

	public void setUserDao(UserDAO userDao) {
		this.userDao = userDao;
	}

	@Override
	public UserVO login(String userid, String userpwd) {
		// TODO Auto-generated method stub
		return userDao.login(userid, userpwd);
	}
	
}

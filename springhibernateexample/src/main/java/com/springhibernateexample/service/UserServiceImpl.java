package com.springhibernateexample.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernateexample.dao.UserDao;
import com.springhibernateexample.generated.User;
import com.springhibernateexample.vo.UserVO;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	@Override
	public UserVO getUser(int id) {
		User user = userDao.get(id);
		return (convertUserToUserVO(user));
	}

	@Override
	public int authenticate(String shortId, String password) {
		User user = userDao.getByShortId(shortId);
		
		return user!=null ? 1 : 0; //for now presence of user means user is valid.
	}
	
	private UserVO convertUserToUserVO(User user)
	{
		UserVO userVO = new UserVO();
		
		userVO.setId(user.getId());
		userVO.setStudyClass(user.getClass_());
		userVO.setName(user.getName());
		userVO.setShortId(user.getShortId());
		return userVO;
	}

}

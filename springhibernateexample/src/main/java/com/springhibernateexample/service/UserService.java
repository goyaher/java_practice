package com.springhibernateexample.service;

import com.springhibernateexample.vo.UserVO;

public interface UserService 
{
	UserVO getUser(int id);
	
	int authenticate(String shortId, String password);
}

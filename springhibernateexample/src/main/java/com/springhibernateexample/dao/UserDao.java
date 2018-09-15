package com.springhibernateexample.dao;

import com.springhibernateexample.generated.User;

public interface UserDao 
{
	User get(int id);
	User getByShortId(String shortId);
}

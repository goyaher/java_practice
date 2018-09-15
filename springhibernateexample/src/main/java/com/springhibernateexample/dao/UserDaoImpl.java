package com.springhibernateexample.dao;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.springhibernateexample.generated.User;

@Component
public class UserDaoImpl extends AbstractHibernateDao<Integer, User> implements UserDao
{
	@Override
	public User get(int id) 
	{
		return getByKey(id);
	}
	
	@Override
	public User getByShortId(String shortId)
	{
		String hql = "FROM User U WHERE U.shortId = :shortId";
		Query<User> query = getSession().createQuery(hql);
		query.setParameter("shortId", shortId);
		User user = query.uniqueResult();
		return user;
	}
}

package com.springhibernateexample.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.query.Query;
import org.springframework.stereotype.Component;

import com.springhibernateexample.generated.Book;

@Component
public class BookDaoImpl extends AbstractHibernateDao<Integer, Book> implements BookDao 
{
	public Book getBook(int id) 
	{
		return getByKey(id);
	}

	public void deleteBook(int id) 
	{
		Book book = getBook(id);
		delete(book);
	}

	public void saveBook(Book book) 
	{
		persist(book);
	}

	public List<Book> findAllBooks() 
	{
		CriteriaBuilder builder = getSession().getCriteriaBuilder();
		CriteriaQuery<Book> query = builder.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		query.select(root);
		
		Query<Book> q = getSession().createQuery(query);
		
		return (List<Book>)q.getResultList();
	}
}

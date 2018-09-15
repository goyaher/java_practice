package com.springhibernateexample.dao;

import java.util.List;

import com.springhibernateexample.generated.Book;

public interface BookDao 
{
	Book getBook(int id);
	
	void deleteBook(int id);
	
	void saveBook(Book book);
	
	List<Book> findAllBooks();
}

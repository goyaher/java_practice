package com.springhibernateexample.service;

import java.util.List;

import com.springhibernateexample.vo.BookVO;

public interface BookService 
{
	BookVO getBook(int id);
	
	void deleteBook(int id);
	
	void insertBook(BookVO book);
	
	void updateBook(BookVO book);
	
	List<BookVO> getAllBooks();
	
	List<BookVO> findByNameLike(String name);
	
}

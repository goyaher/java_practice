package com.springhibernateexample.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springhibernateexample.dao.BookDao;
import com.springhibernateexample.generated.Book;
import com.springhibernateexample.vo.BookVO;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookDao bookDao;
	
	@Override
	public BookVO getBook(int id) 
	{
		Book book = bookDao.getBook(id);
		return convertBookToBookVO(book);
	}

	@Override
	public void deleteBook(int id) 
	{
		bookDao.deleteBook(id);
	}

	@Override
	public void insertBook(BookVO book) 
	{
		bookDao.saveBook(convertBookVOToBook(book));
	}

	@Override
	public void updateBook(BookVO book) 
	{
		bookDao.saveBook(convertBookVOToBook(book));
	}

	@Override
	public List<BookVO> getAllBooks() 
	{
		List<Book> books = bookDao.findAllBooks();
		List<BookVO> bookVOs = new ArrayList<BookVO>();

		for (Book book: books)
		{
			bookVOs.add(convertBookToBookVO(book));
		}
		
		return bookVOs;
	}

	@Override
	public List<BookVO> findByNameLike(String name) 
	{
		//TODO:
		return null;
	}
	
	private BookVO convertBookToBookVO(Book book)
	{
		BookVO bookVO = new BookVO();
		bookVO.setId(book.getId());
		bookVO.setCategoryId(book.getCategory().getId());
		bookVO.setCategoryName(book.getCategory().getName());
		bookVO.setCopies(book.getCopies());
		bookVO.setName(book.getName());
		
//		
//		bookVO.setAuthor
		return bookVO;
	}
	
	private Book convertBookVOToBook(BookVO bookVO)
	{
		Book book = new Book();
		book.setId(bookVO.getId());
		
		//TODO:
		return book;
	}

}

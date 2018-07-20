package com.springhibernateexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springhibernateexample.service.BookService;
import com.springhibernateexample.service.UserService;
import com.springhibernateexample.vo.BookVO;
import com.springhibernateexample.vo.common.ResponseVO;

@Controller
@RequestMapping("/library")
public class LibraryController 
{
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login/{shortId}/{password}", method = RequestMethod.GET)
	public @ResponseBody ResponseVO login_Del(@PathVariable String shortId, @PathVariable String password)
	{
		return login(shortId, password);
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public @ResponseBody ResponseVO login(@RequestParam String shortId, @RequestParam String password)
	{
		int authenticated = userService.authenticate(shortId, password);
		return authenticated == 1 ? new ResponseVO(1) : new ResponseVO(0, "Authentication Failed"); 
	}
	
	@RequestMapping(value="/book/get/{id}", method = RequestMethod.GET)
	public @ResponseBody BookVO getBook(@PathVariable int id)
	{
		return bookService.getBook(id);
	}
	
	@RequestMapping(value="/book/get/all", method = RequestMethod.GET)
	public @ResponseBody List<BookVO> getBook()
	{
		List<BookVO> books = bookService.getAllBooks();
		return books.isEmpty() ? null : books;
	}
}

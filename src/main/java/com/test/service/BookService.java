package com.test.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.test.dao.Reposetriy;
import com.test.entity.Book;
@Component
public class BookService {
	@Autowired
	private Reposetriy reposetriy;
	public List<Book> getAllBooks(){
		List<Book> findAll = (List<Book>)this.reposetriy.findAll();
		return findAll;
	}
	
	public Book getBookById(int id) {
		Book findById = this.reposetriy.findById(id);
		return findById;
	}
	public Book insertbook(Book book) {
		Book save = this.reposetriy.save(book);
      return save;		
	}
	public void delete(int id) {
		this.reposetriy.deleteById(id);
		
	}
	public void updateBook(Book book, int bookId) {
		book.setId(bookId);
		reposetriy.save(book);
		
	     
	}

}

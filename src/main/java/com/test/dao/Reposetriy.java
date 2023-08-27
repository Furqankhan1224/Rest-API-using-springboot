package com.test.dao;

import org.springframework.data.repository.CrudRepository;

import com.test.entity.Book;

public interface Reposetriy extends CrudRepository<Book, Integer> {
	public Book findById(int id);
}

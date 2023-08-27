package com.test.entity;

import org.hibernate.engine.internal.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Book {
	@Id
	private int id;
	private String title;
  @OneToOne(cascade = CascadeType.ALL)
	private Author author;
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
public Book(int id, String title) {
	super();
	this.id = id;
	this.title = title;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
@Override
public String toString() {
	return "Book [id=" + id + ", title=" + title + "]";
}
	


	

}

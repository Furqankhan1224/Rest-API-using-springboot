package com.test.entity;

import org.hibernate.engine.internal.Cascade;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Author {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int authodId;
	private String firstName;
	private String lastName;
	private String language;
	@OneToOne(mappedBy = "author")
	private Book book;
	public Author() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Author(int authodId, String firstName, String lastName, String language) {
		super();
		this.authodId = authodId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.language = language;
	}
	public int getAuthodId() {
		return authodId;
	}
	public void setAuthodId(int authodId) {
		this.authodId = authodId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Author [authodId=" + authodId + ", firstName=" + firstName + ", lastName=" + lastName + ", language="
				+ language + "]";
	}


}

package com.test;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.test.entity.Book;
import com.test.service.BookService;

@RestController
public class BookController {
	@Autowired
	private BookService bookService;
	@GetMapping("/books")
   public ResponseEntity<List<Book>> getBooks() {
	   List<Book> list =this.bookService.getAllBooks();
	    if(list.size()<=0) {
	    	return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	    }
		return ResponseEntity.of(Optional.of(list));
   }
	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getbookbyId(@PathVariable("id") int id) {
		Book list=this.bookService.getBookById(id);
		if(list==null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list));
		
	}
	@PostMapping("/books")
	public ResponseEntity<Book> insert(@RequestBody Book book) {
		Book b = null;
	try {
		   b = this.bookService.insertbook(book);
		   System.out.println(b);
		   return ResponseEntity.of(Optional.of(b));
	} catch (Exception e) {
		e.printStackTrace();
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	}
	@DeleteMapping("/books/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") int id) {
		try {
	   this.bookService.delete(id);
	   return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}catch (Exception e) {
			e.printStackTrace();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	@PutMapping("/books/{bookId}")
	public ResponseEntity<Book> updatebook(@RequestBody Book book,@PathVariable("bookId") int bookId) {
	
	    try {
	    	this.bookService.updateBook(book,bookId);
	    	return ResponseEntity.of(Optional.of(book));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	    
}}

package com.libraries.libraries.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.libraries.libraries.dataobject.Book;
import com.libraries.libraries.serviceimpl.BookServiceImpl;

@RestController
@RequestMapping("/book")
public class BookController {

	
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@RequestMapping("/createBook")
	public ResponseEntity<?> createNewBook(@RequestBody Book book){
		
		Book book1 = bookServiceImpl.createNewBookObject(book);
		return new ResponseEntity<Book>(book1, HttpStatus.CREATED);
	}
	
	@GetMapping("/{bookId}")
	public ResponseEntity<?> findBookById(@PathVariable Long bookId){
		Book book = bookServiceImpl.findBookByIndentifier(bookId);
		return new ResponseEntity<Book>(book, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Book> findAllBooks(){
		List<Book> allBooks = bookServiceImpl.getAllBooks();
		return allBooks;
	}
	
	@DeleteMapping("/{bookId}")
	public ResponseEntity<?> deleteBook(@PathVariable Long bookId){
		String message = bookServiceImpl.deleteBookByIdentifier(bookId);
		Map<String,String> messages = new HashMap<>();
		messages.put("message", message);
		return new ResponseEntity<Map<String,String>>(messages,HttpStatus.OK);
	}
	
	@GetMapping("/libbooks/{libId}")
	public List<Book> findBooksByLibraryId(@PathVariable Long libId){
		List<Book> books = bookServiceImpl.getAllBooksByUsingLibId(libId);
		return books;
	}
}

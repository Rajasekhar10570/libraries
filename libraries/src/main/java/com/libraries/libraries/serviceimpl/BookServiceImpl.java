package com.libraries.libraries.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraries.libraries.dataobject.Book;
import com.libraries.libraries.repositories.BookRepository;
import com.libraries.libraries.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository repository;
	
	public Book createNewBookObject(Book book) {
		try {
			book.setBookId(book.getBookId());
			return repository.save(book);
		}catch(Exception ex) {
			//It should throw some exception here
			ex.printStackTrace();
		}
		return null;
	}
	
	public Book findBookByIndentifier(Long bookId) {
		Optional<Book> book = repository.findById(bookId);
		
		if(book == null) {
			//It should throw some Exception here
			return null;
		}
		return book.get();
	}
	
	public List<Book> getAllBooks(){
		return repository.findAll();
	}
	
	public String deleteBookByIdentifier(Long bookId) {
		Optional<Book> book = repository.findById(bookId);
		if(book == null) {
			return "Can not exist with this project id  '"+bookId+"'.";
		} else {
			repository.delete(book.get());
			return "Deleted Project with Id "+bookId+" Successfully.";
		}
	}

	@Override
	public List<Book> getAllBooksByUsingLibId(Long libId) {
		List<Book> books = repository.findListOfBooks(libId);
		return books;
	}

	

}

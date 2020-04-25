package com.libraries.libraries.service;

import java.util.List;

import com.libraries.libraries.dataobject.Book;

public interface BookService {

	public Book createNewBookObject(Book book);
	public Book findBookByIndentifier(Long bookId);
	public List<Book> getAllBooks();
	public String deleteBookByIdentifier(Long bookId);
	
	public List<Book> getAllBooksByUsingLibId(Long libId);
}

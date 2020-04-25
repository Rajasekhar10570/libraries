package com.libraries.libraries.dataobject;

import javax.persistence.*;


@Entity
@Table(name="book", uniqueConstraints = {@UniqueConstraint(columnNames = {"bookId"})})

public class Book {

	private Long bookId;
	private String bookName;
	private String author;
	private Integer noOfPages;
	private Boolean isAvailable;
	
	
    private Library library;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getBookId() {
		return bookId;
	}
	public void setBookId(Long id) {
		this.bookId = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public Integer getNoOfPages() {
		return noOfPages;
	}
	public void setNoOfPages(Integer noOfPages) {
		this.noOfPages = noOfPages;
	}
	public Boolean getIsAvailable() {
		return isAvailable;
	}
	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@ManyToOne
	//@JoinColumn(name="libId")
	public Library getLibrary() {
		return library;
	}
	public void setLibrary(Library library) {
		this.library = library;
	}
	
	
}

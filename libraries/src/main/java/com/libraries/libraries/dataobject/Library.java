package com.libraries.libraries.dataobject;

import java.util.*;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "library")
public class Library {

	
	private Long libId;
	private String libraryName;
	private String booksCategory;
	private Long booksCount;
	
	@JsonIgnore
    private List<Book> items;
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getLibId() {
		return libId;
	}
	public void setLibId(Long libId) {
		this.libId = libId;
	}
	public String getLibraryName() {
		return libraryName;
	}
	public void setLibraryName(String libraryName) {
		this.libraryName = libraryName;
	}
	public String getBooksCategory() {
		return booksCategory;
	}
	public void setBooksCategory(String booksCategory) {
		this.booksCategory = booksCategory;
	}
	public Long getBooksCount() {
		return booksCount;
	}
	public void setBooksCount(Long booksCount) {
		this.booksCount = booksCount;
	}
	
	@OneToMany(targetEntity=Book.class, mappedBy="library", fetch=FetchType.EAGER)
	public List<Book> getItems() {
		return items;
	}
	public void setItems(List<Book> items) {
		this.items = items;
	}
	
	
}

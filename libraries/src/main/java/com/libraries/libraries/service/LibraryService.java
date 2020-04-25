package com.libraries.libraries.service;

import java.util.List;

import com.libraries.libraries.dataobject.Library;

public interface LibraryService {

	public Library createNewLibraryObject(Library book);
	public Library findLibraryByIndentifier(Long id);
	public List<Library> getAllLibrarys();
	public String deleteLibraryByIdentifier(Long libraryId);
	
}

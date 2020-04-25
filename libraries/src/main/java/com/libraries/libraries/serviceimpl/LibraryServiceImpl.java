package com.libraries.libraries.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.libraries.libraries.dataobject.Library;
import com.libraries.libraries.repositories.LibraryRepository;
import com.libraries.libraries.service.LibraryService;

@Service
public class LibraryServiceImpl implements LibraryService {

	@Autowired
	private LibraryRepository repository;
	
	public Library createNewLibraryObject(Library library) {
		try {
			library.setLibId(library.getLibId());
			return repository.save(library);
		}catch(Exception ex) {
			//It should throw some exception
			ex.printStackTrace();
		}
		return null;
	}
	
	public Library findLibraryByIndentifier(Long id) {
		Optional<Library> library = repository.findById(id);
		
		if(library == null) {
			//It should throw some exception here
			return null;
		}
		return library.get();
	}
	
	public List<Library> getAllLibrarys(){
		return repository.findAll();
	}
	
	public String deleteLibraryByIdentifier(Long libraryId) {
		Optional<Library> library = repository.findById(libraryId);
		if(library == null) {
			return "Can not exist with this library id  '"+libraryId+"'.";
		} else {
			repository.delete(library.get());
			return "Deleted library with Id "+libraryId+" Successfully.";
		}
	}

}

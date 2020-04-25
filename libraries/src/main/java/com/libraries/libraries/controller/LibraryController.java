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

import com.libraries.libraries.dataobject.Library;
import com.libraries.libraries.serviceimpl.LibraryServiceImpl;

@RestController
@RequestMapping("/library")
public class LibraryController {

	@Autowired
	LibraryServiceImpl libraryServiceImpl;
	
	@RequestMapping("/createLibrary")
	public ResponseEntity<?> createNewLibrary(@RequestBody Library book){
		
		Library book1 = libraryServiceImpl.createNewLibraryObject(book);
		return new ResponseEntity<Library>(book1, HttpStatus.CREATED);
	}
	
	@GetMapping("/{libraryId}")
	public ResponseEntity<?> findLibraryById(@PathVariable Long libraryId){
		Library book = libraryServiceImpl.findLibraryByIndentifier(libraryId);
		return new ResponseEntity<Library>(book, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public List<Library> findAllLibrarys(){
		List<Library> allProjects = libraryServiceImpl.getAllLibrarys();
		return allProjects;
	}
	
	@DeleteMapping("/{libraryId}")
	public ResponseEntity<?> deleteProject(@PathVariable Long libraryId){
		String message = libraryServiceImpl.deleteLibraryByIdentifier(libraryId);
		Map<String,String> messages = new HashMap<>();
		messages.put("message", message);
		return new ResponseEntity<Map<String,String>>(messages,HttpStatus.OK);
	}
}

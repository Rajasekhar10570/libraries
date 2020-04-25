package com.libraries.libraries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.libraries.libraries.dataobject.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE b.library.libId = :libId")
	public List<Book> findListOfBooks(@Param("libId") Long libId);
}

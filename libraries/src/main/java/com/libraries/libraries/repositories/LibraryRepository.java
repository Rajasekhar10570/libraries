package com.libraries.libraries.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.libraries.libraries.dataobject.Library;

public interface LibraryRepository extends JpaRepository<Library, Long> {

}

package com.triki.bookclub.Respositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.souha.bookclub.Models.Book;

public interface BookRepo extends CrudRepository<Book, Long> {
	// Read All
	List<Book> findAll();
}

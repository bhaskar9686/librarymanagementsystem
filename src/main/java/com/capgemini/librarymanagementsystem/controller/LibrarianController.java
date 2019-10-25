package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;
import com.capgemini.librarymanagementsystem.service.LibrarianServices;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LibrarianController {

	@Autowired
	LibrarianServices service;

	@PostMapping("/lims/admin/create")
	public Users addStudent(@RequestBody Users users) {
		try {
			users = service.registerStudent(users);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return users;
	}// end of addStudent()

	@PostMapping("/lims/librarian/create")
	public BooksInventory addBooks(@RequestBody BooksInventory booksInventory) {
		try {
			booksInventory = service.addBooks(booksInventory);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return booksInventory;
	}// end of addBooks()

	@DeleteMapping("/lims/librarian/{bookId}")
	public Boolean deleteBook(@PathVariable("bookId") int bookId) {

		boolean isDeleted = false;

		try {
			service.deleteBook(bookId);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isDeleted;
	}// end of deleteBook()

	@GetMapping("/lims/librarian/getBooks/{bookName}/{author}")
	public List<BooksInventory> searchBook(@PathVariable("bookName")String bookName, @PathVariable("author") String author) {
		List<BooksInventory> bookList = null;

		try {
			bookList = service.searchBook(bookName, author);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return bookList;
	}// end of searchBook()

}


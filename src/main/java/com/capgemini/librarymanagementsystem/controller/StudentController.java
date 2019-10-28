package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;
import com.capgemini.librarymanagementsystem.service.StudentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

	@Autowired
	StudentService service;
	
	@PostMapping("/lims/librarian/getBooks/")
	public List<BooksInventory> searchBook(@RequestBody BooksInventory booksInventory) {
		List<BooksInventory> bookList = null;
		try {
			bookList = service.searchBook(booksInventory);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return bookList;
	}// end of searchBook()
	
	@GetMapping("lims/student/book/requset/{bookId}")
	public Boolean requestBook(@PathVariable("bookId") int bookId) {
		boolean isRequested = false;
		try {
			service.requestBook(bookId);
			isRequested = true;
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isRequested;
	}// end of requestBook()
	
	@GetMapping("lims/student/book/requsetStatus/{id}")
	public List<BooksTransaction> requestStatus(@PathVariable("id") int id) {
		List<BooksTransaction> booksTransactions = null;
		try {
			booksTransactions = service.requestStatus(id);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return booksTransactions;
	}// end of requestStatus()
}

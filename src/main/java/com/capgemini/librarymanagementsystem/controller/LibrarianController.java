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
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;
import com.capgemini.librarymanagementsystem.service.LibrarianService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LibrarianController {

	@Autowired
	LibrarianService service;

	@PostMapping("/lims/librarian/user")
	public Users addStudent(@RequestBody Users users) {
		try {
			users = service.registerStudent(users);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return users;
	}// end of addStudent()

	@GetMapping("/lims/librarian/getStudent/{id}")
	public Users getStuentInfo(@PathVariable("id")int id) {
		Users users = null;
		try {
			users = service.getStudentInfo(id);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return users;
	}// end of getStudentInfo()

	@DeleteMapping("/lims/librarian/deleteStudent/{id}")
	public Boolean deleteStudent(@PathVariable("id") int id) {
		boolean isDeleted = false;
		try {
			isDeleted = service.deleteStudent(id);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isDeleted;
	}// end of deleteStudent()

	@PostMapping("/lims/librarian/create")
	public Boolean addBooks(@RequestBody BooksInventory booksInventory) {
		boolean isAdded = false;
		try {
			service.addBooks(booksInventory);
			isAdded = true;
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isAdded;
	}// end of addBooks()

	@DeleteMapping("/lims/librarian/{bookId}")
	public Boolean deleteBook(@PathVariable("bookId") int bookId) {
		boolean isDeleted = false;
		try {
			service.deleteBook(bookId);
			isDeleted = true;
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isDeleted;
	}// end of deleteBook()

	@GetMapping("/lims/librarian/getBooks")
	public List<BooksInventory> showAllBook() {
		List<BooksInventory> bookList = null;
		try {
			bookList = service.showAllBooks();
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return bookList;
	}// end of showAllBooks()

	@GetMapping("/lims/librarian/viewRequest")
	public List<BooksRegistration> viewRequests() {
		List<BooksRegistration> booksRegistrations = null;
		try {
			booksRegistrations = service.viewRequest();
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return booksRegistrations;
	}// end of viewRequest()

	@GetMapping("/lims/librarian/acceptRequest/{registrationId}")
	public BooksTransaction acceptRequest(@PathVariable("registrationId") int registrationId) {
		BooksTransaction booksTransaction = null;
		try {
			booksTransaction = service.acceptRequest(registrationId);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return booksTransaction;
	}// end of acceptRequest()

	@DeleteMapping("/lims/librarian/denyRequest/{registrationId}")
	public Boolean denyRequest(@PathVariable("registrationId") int registrationId) {
		boolean isDeny = false;
		try {
			isDeny = service.denyRequest(registrationId);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isDeny;
	}// end of acceptRequest()

	@GetMapping("/lims/librarian/getIssuedInfo/{id}")
	public BooksTransaction getIssuedBookInfo(@PathVariable("id") int id) {
		BooksTransaction booksTransaction = null;
		try {
			booksTransaction = service.getIssuedBookInfo(id);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return booksTransaction;
	}// end of getIssuedBookInfo()

	@DeleteMapping("/lims/librarian/returnBook/{id}")
	public Boolean returnBook(@PathVariable("id")int id) {
		boolean isReturned = false;
		try {
			service.returnBook(id);
			isReturned = true;
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isReturned;
	}// end of returnBook()
	
	@GetMapping("/lims/librarian/getIssuedBooks")
	public List<BooksTransaction> issuedBook() {
		List<BooksTransaction> booksTransactions = null;
		try {
			booksTransactions = service.issuedBooks();
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return booksTransactions;
	}// end of issuedBook()
}

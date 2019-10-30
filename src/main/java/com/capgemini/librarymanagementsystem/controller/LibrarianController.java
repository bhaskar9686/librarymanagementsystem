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
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.response.BookResponse;
import com.capgemini.librarymanagementsystem.response.BooksRegistrationResponse;
import com.capgemini.librarymanagementsystem.response.BooksTransactionResponse;
import com.capgemini.librarymanagementsystem.response.UsersResponse;
import com.capgemini.librarymanagementsystem.service.LibrarianService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LibrarianController {

	@Autowired
	private LibrarianService service;

	@PostMapping("/lims/librarian/user")
	public UsersResponse addStudent(@RequestBody Users users) {
		UsersResponse response = new UsersResponse();
		try {
			users = service.registerStudent(users);
			if (users != null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Student Added Successfully");
				response.setUsers(users);
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Add Student");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of addStudent()

	@GetMapping("/lims/librarian/getStudent/{id}")
	public UsersResponse getStuentInfo(@PathVariable("id") int id) {
		Users users = null;
		UsersResponse response = new UsersResponse();
		try {
			users = service.getStudentInfo(id);
			if (users != null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Student Data Fetched Successfully");
				response.setUsers(users);
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Fetch the Data Student");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of getStudentInfo()

	@DeleteMapping("/lims/librarian/deleteStudent/{id}")
	public UsersResponse deleteStudent(@PathVariable("id") int id) {
		UsersResponse response = new UsersResponse();
		try {
			if (service.deleteStudent(id)) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("User Deleted Successfully");
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Delete User");
			}

		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of deleteStudent()

	@PostMapping("/lims/librarian/create")
	public BookResponse addBooks(@RequestBody BooksInventory booksInventory) {
		BookResponse response = new BookResponse();
		try {
			if (service.addBooks(booksInventory)) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Book Added Successfully");
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Add Book");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of addBooks()

	@DeleteMapping("/lims/librarian/{bookId}")
	public BookResponse deleteBook(@PathVariable("bookId") int bookId) {
		BookResponse response = new BookResponse();
		try {
			if (service.deleteBook(bookId)) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Book Deleted Successfully");
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Delete Book");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of deleteBook()

	@GetMapping("/lims/librarian/getBooks")
	public BookResponse showAllBook() {
		List<BooksInventory> bookList = null;
		BookResponse response = new BookResponse();
		try {
			bookList = service.showAllBooks();
			if (bookList != null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Book Fetched Successfully");
				response.setBookList(bookList);
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Fetch Book");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of showAllBooks()

	@GetMapping("/lims/librarian/viewRequest")
	public BooksRegistrationResponse viewRequests() {
		List<BooksRegistration> booksRegistrations = null;
		BooksRegistrationResponse response = new BooksRegistrationResponse();
		try {
			booksRegistrations = service.viewRequest();
			if (booksRegistrations != null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Request Viewed Successfully");
				response.setBookList(booksRegistrations);
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to view Request");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of viewRequest()

	@GetMapping("/lims/librarian/acceptRequest/{registrationId}")
	public BooksTransactionResponse acceptRequest(@PathVariable("registrationId") int registrationId) {
		BooksTransaction booksTransaction = null;
		BooksTransactionResponse response = new BooksTransactionResponse();
		try {
			booksTransaction = service.acceptRequest(registrationId);
			if (booksTransaction != null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Request Accepted Successfully");
				response.setBooksTransaction(booksTransaction);
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to accept Request");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of acceptRequest()

	@DeleteMapping("/lims/librarian/denyRequest/{registrationId}")
	public BooksTransactionResponse denyRequest(@PathVariable("registrationId") int registrationId) {
		BooksTransactionResponse response = new BooksTransactionResponse();
		try {
			if (service.denyRequest(registrationId)) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Request Denyed Successfully");
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to deny Request");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of acceptRequest()

	@GetMapping("/lims/librarian/getIssuedInfo/{id}")
	public BooksTransactionResponse getIssuedBookInfo(@PathVariable("id") int id) {
		BooksTransaction booksTransaction = null;
		BooksTransactionResponse response = new BooksTransactionResponse();
		try {
			booksTransaction = service.getIssuedBookInfo(id);
			if (booksTransaction != null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Successfully fetched the Issued Book");
				response.setBooksTransaction(booksTransaction);
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to fetch the Issued book");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of getIssuedBookInfo()

	@DeleteMapping("/lims/librarian/returnBook/{id}")
	public BooksTransactionResponse returnBook(@PathVariable("id") int id) {
		BooksTransactionResponse response = new BooksTransactionResponse();
		try {
			if(service.returnBook(id)) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Successfully Book Returned");
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to return the book");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of returnBook()

	@GetMapping("/lims/librarian/getIssuedBooks")
	public BooksTransactionResponse issuedBook() {
		BooksTransactionResponse response =new BooksTransactionResponse();
		List<BooksTransaction> booksTransactions = null;
		try {
			booksTransactions = service.issuedBooks();
			if(booksTransactions!=null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Successfully Fetched the Issued book");
				response.setTransactionList(booksTransactions);
			} else {
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to fetch the Issued book");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of issuedBook()
}

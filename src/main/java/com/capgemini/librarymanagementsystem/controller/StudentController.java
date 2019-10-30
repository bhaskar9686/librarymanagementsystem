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
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.response.BookResponse;
import com.capgemini.librarymanagementsystem.response.BooksTransactionResponse;
import com.capgemini.librarymanagementsystem.service.StudentService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class StudentController {

	@Autowired
	private StudentService service;

	@PostMapping("/lims/librarian/getBooks/")
	public BookResponse searchBook(@RequestBody BooksInventory booksInventory) {
		List<BooksInventory> bookList = null;
		BookResponse response = new BookResponse();
		try {
			bookList = service.searchBook(booksInventory);
			if(bookList!=null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Book Fetched Successfully");
				response.setBookList(bookList);
			} else
			{
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Fetch the Book");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of searchBook()

	@GetMapping("lims/student/book/requset/{bookId}")
	public BookResponse requestBook(@PathVariable("bookId") int bookId) {
		BookResponse response = new BookResponse();
		try {
			if(service.requestBook(bookId)) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Book requested Successfully");
			} else
			{
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to request the Book");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of requestBook()

	@GetMapping("lims/student/book/requsetStatus/{id}")
	public BooksTransactionResponse requestStatus(@PathVariable("id") int id) {
		List<BooksTransaction> booksTransactions = null;
		BooksTransactionResponse response = new BooksTransactionResponse();
		try {
			booksTransactions = service.requestStatus(id);
			if(booksTransactions!=null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("Book Accepted Successfully");
				response.setTransactionList(booksTransactions);
			} else
			{
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to accept the Book");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of requestStatus()
}

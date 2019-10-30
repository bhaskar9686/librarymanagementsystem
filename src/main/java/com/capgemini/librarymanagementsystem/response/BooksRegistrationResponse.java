package com.capgemini.librarymanagementsystem.response;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksRegistration;

public class BooksRegistrationResponse {
	private String status;
	private String message;
	private String description;
	private BooksRegistration booksRegistration;
	private List<BooksRegistration> bookList;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public BooksRegistration getBooksRegistration() {
		return booksRegistration;
	}
	public void setBooksRegistration(BooksRegistration booksRegistration) {
		this.booksRegistration = booksRegistration;
	}
	public List<BooksRegistration> getBookList() {
		return bookList;
	}
	public void setBookList(List<BooksRegistration> bookList) {
		this.bookList = bookList;
	}
	
}

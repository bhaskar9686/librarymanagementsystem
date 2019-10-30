package com.capgemini.librarymanagementsystem.response;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;

public class BookResponse {

	private String status;
	private String message;
	private String description;
	private BooksInventory booksInventory;
	private List<BooksInventory> bookList;
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
	public BooksInventory getBooksInventory() {
		return booksInventory;
	}
	public void setBooksInventory(BooksInventory booksInventory) {
		this.booksInventory = booksInventory;
	}
	public List<BooksInventory> getBookList() {
		return bookList;
	}
	public void setBookList(List<BooksInventory> bookList) {
		this.bookList = bookList;
	}
	
}

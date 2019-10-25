package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;

public interface LibrarianServices {

	public BooksInventory addBooks(BooksInventory booksInventory);
	public Boolean deleteBook(int bookId);
	public List<BooksInventory> searchBook(String bookName, String author);
		
}

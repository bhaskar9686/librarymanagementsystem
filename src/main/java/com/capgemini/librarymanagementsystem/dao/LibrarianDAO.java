package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;

public interface LibrarianDAO {

	public BooksInventory addBooks(BooksInventory booksInventory);
	
	public Boolean deleteBook(int bookId);
	
	public List<BooksInventory> searchBook(String bookName, String author);
	

	
	
}

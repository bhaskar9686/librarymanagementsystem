package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface LibrarianServices {

	public BooksInventory addBooks(BooksInventory booksInventory) throws CustomException;
	public Boolean deleteBook(int bookId) throws CustomException;
	public List<BooksInventory> searchBook(String bookName, String author) throws CustomException;
	public Users registerStudent(Users users) throws CustomException;
		
}

package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface LibrarianDAO {

	public Users registerStudent(Users user)throws CustomException;
	public BooksInventory addBooks(BooksInventory booksInventory) throws CustomException;
	public Boolean deleteBook(int bookId) throws CustomException;
	public List<BooksInventory> searchBook(String bookName, String author) throws CustomException;
	

	
	
}

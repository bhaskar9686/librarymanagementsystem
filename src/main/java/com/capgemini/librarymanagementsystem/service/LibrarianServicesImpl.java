package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public class LibrarianServicesImpl implements LibrarianServices {


	@Autowired
	LibrarianDAO dao;
	
	@Override
	public BooksInventory addBooks(BooksInventory booksInventory) throws CustomException{
		return dao.addBooks(booksInventory);
	}

	@Override
	public Boolean deleteBook(int bookId) throws CustomException{
		return dao.deleteBook(bookId);
	}

	@Override
	public List<BooksInventory> searchBook(String bookName, String author) throws CustomException{
		return dao.searchBook(bookName, author);
	}

	@Override
	public Users registerStudent(Users users) throws CustomException {
		return dao.registerStudent(users);
	}

}

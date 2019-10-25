package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;

public class LibrarianServicesImpl implements LibrarianServices {


	@Autowired
	LibrarianDAO dao;
	
	@Override
	public BooksInventory addBooks(BooksInventory booksInventory) {
		return dao.addBooks(booksInventory);
	}

	@Override
	public Boolean deleteBook(int bookId) {
		return dao.deleteBook(bookId);
	}

	@Override
	public List<BooksInventory> searchBook(String bookName, String author) {
		return dao.searchBook(bookName, author);
	}

}

package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.dao.StudentDAO;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDAO dao;

	@Override
	public List<BooksInventory> searchBook(BooksInventory booksInventory) throws LibraryManagementSystemException {
		return dao.searchBook(booksInventory);
	}// end of searchBook()

	@Override
	public Boolean requestBook(int bookId) throws LibraryManagementSystemException {
		return dao.requestBook(bookId);
	}// end of requestBook()

	@Override
	public List<BooksTransaction> requestStatus(int id) throws LibraryManagementSystemException {
		return dao.requestStatus(id);
	}// end of requestStatus()

}

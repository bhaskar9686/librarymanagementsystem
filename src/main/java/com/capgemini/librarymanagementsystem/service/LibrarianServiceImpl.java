package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Service
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	LibrarianDAO dao;
	
	@Override
	public Boolean addBooks(BooksInventory booksInventory) throws CustomException {
		return dao.addBooks(booksInventory);
	}// end of addBooks() 

	@Override
	public Boolean deleteBook(int bookId) throws CustomException {
		return dao.deleteBook(bookId);
	}// end of deleteBooks()

	@Override
	public Users registerStudent(Users user) throws CustomException {
		return dao.registerStudent(user);
	}// end of registerStudent()

	@Override
	public List<BooksInventory> showAllBooks() throws CustomException {
		return dao.showAllBooks();
	}// end of showAllBooks()

	@Override
	public Users getStudentInfo(int id) throws CustomException {
		return dao.getStudentInfo(id);
	}// end of getStudentInfo()

	@Override
	public Boolean deleteStudent(int id) throws CustomException {
		return dao.deleteStudent(id);
	}// edn of deleteStudent()

	@Override
	public List<BooksRegistration> viewRequest() throws CustomException {
		return dao.viewRequest();
	}

}

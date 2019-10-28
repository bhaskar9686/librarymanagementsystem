package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Service
public class LibrarianServiceImpl implements LibrarianService {

	@Autowired
	LibrarianDAO dao;

	@Override
	public Users registerStudent(Users user) throws CustomException {
		return dao.registerStudent(user);
	}// end of registerStudent()

	@Override
	public Users getStudentInfo(int id) throws CustomException {
		return dao.getStudentInfo(id);
	}// end of getStudentInfo()

	@Override
	public Boolean deleteStudent(int id) throws CustomException {
		return dao.deleteStudent(id);
	}// end of deleteStudent()

	@Override
	public List<BooksRegistration> viewRequest() throws CustomException {
		return dao.viewRequest();
	}// end of viewRequest()

	@Override
	public BooksTransaction acceptRequest(int registrationId) throws CustomException {
		return dao.acceptRequest(registrationId);
	}// end of acceptRequest()

	@Override
	public Boolean denyRequest(int registrationId) throws CustomException {
		return dao.denyRequest(registrationId);
	}// end of denyRequest()

	@Override
	public BooksTransaction getIssuedBookInfo(int id) throws CustomException {
		return dao.getIssuedBookInfo(id);
	}// end of getIssuedBookInfo()

	@Override
	public Boolean returnBook(int id) throws CustomException {
		return dao.returnBook(id);
	}// end of returnBook()

	@Override
	public List<BooksTransaction> issuedBooks() throws CustomException {
		return dao.issuedBooks();
	}// end of issuedBook()

	@Override
	public Boolean addBooks(BooksInventory booksInventory) throws CustomException {
		return dao.addBooks(booksInventory);
	}// end of addBooks() 

	@Override
	public Boolean deleteBook(int bookId) throws CustomException {
		return dao.deleteBook(bookId);
	}// end of deleteBooks()

	@Override
	public List<BooksInventory> showAllBooks() throws CustomException {
		return dao.showAllBooks();
	}// end of showAllBooks()

}

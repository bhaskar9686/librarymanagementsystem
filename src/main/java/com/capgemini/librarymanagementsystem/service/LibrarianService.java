package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

public interface LibrarianService {

	public Users registerStudent(Users user) throws LibraryManagementSystemException;

	public Users getStudentInfo(int id) throws LibraryManagementSystemException;

	public Boolean deleteStudent(int id) throws LibraryManagementSystemException;

	public List<BooksRegistration> viewRequest() throws LibraryManagementSystemException;

	public BooksTransaction acceptRequest(int registrationId) throws LibraryManagementSystemException;

	public Boolean denyRequest(int registrationId) throws LibraryManagementSystemException;

	public BooksTransaction getIssuedBookInfo(int id) throws LibraryManagementSystemException;

	public Boolean returnBook(int id) throws LibraryManagementSystemException;

	public List<BooksTransaction> issuedBooks() throws LibraryManagementSystemException;

	public Boolean addBooks(BooksInventory booksInventory) throws LibraryManagementSystemException;

	public Boolean deleteBook(int bookId) throws LibraryManagementSystemException;

	public List<BooksInventory> showAllBooks() throws LibraryManagementSystemException;

}

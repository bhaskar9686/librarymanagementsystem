package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;



/*
 * 
 * author Bhaskar VA 
 * 
 */


public interface StudentService {

	public List<BooksInventory> searchBook(BooksInventory booksInventory) throws LibraryManagementSystemException;

	public Boolean requestBook(int bookId) throws LibraryManagementSystemException;

	public List<BooksTransaction> requestStatus(int id) throws LibraryManagementSystemException;
}

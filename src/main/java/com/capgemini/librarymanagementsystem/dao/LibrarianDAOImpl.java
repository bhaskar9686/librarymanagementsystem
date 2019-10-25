package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;

@Repository
public class LibrarianDAOImpl implements LibrarianDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("LibraryPersistence");
	static final EntityManager MANAGER = FACTORY.createEntityManager();
	
	@Override
	public BooksInventory addBooks(BooksInventory booksInventory) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteBook(int bookId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BooksInventory> searchBook(String bookName, String author) {
		// TODO Auto-generated method stub
		return null;
	}

}

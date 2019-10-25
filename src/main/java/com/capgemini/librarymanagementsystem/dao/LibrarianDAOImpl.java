package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Repository
public class LibrarianDAOImpl implements LibrarianDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("LibraryPersistence");
	static final EntityManager MANAGER = FACTORY.createEntityManager();

	@Override
	public BooksInventory addBooks(BooksInventory booksInventory) throws CustomException {

		try {
			MANAGER.getTransaction().begin();
			MANAGER.persist(booksInventory);
			MANAGER.getTransaction().commit();
			MANAGER.close();
		} catch (Exception e) {
			throw new CustomException("Failed to add Books");
		}
		return booksInventory;

	}

	@Override
	public Boolean deleteBook(int bookId) throws CustomException {
		boolean isDeleted = false;
		try {
			BooksInventory booksInventory = MANAGER.find(BooksInventory.class, bookId );
			MANAGER.getTransaction().begin();
			MANAGER.remove(booksInventory);
			MANAGER.getTransaction().commit();
			MANAGER.close();
		} catch (Exception e) {
			throw new CustomException("Failed to Delete Books");
		}
		return isDeleted;

	}

	@Override
	public List<BooksInventory> searchBook(String bookName, String author) throws CustomException {

		List<BooksInventory> booksList = null;
		try {
			TypedQuery<BooksInventory> typedQuery = MANAGER.createQuery("FROM BooksInventory WHERE bookName = :bName AND author = :author", BooksInventory.class);
			typedQuery.setParameter("bName", bookName);
			typedQuery.setParameter("author", author);
			booksList = typedQuery.getResultList();
		} catch (Exception e) {
			throw new CustomException("No Data Found");
		}
		return booksList;

	}

	@Override
	public Users registerStudent(Users user) throws CustomException {
		user.setType("Student");
		try {
			MANAGER.getTransaction().begin();
			MANAGER.persist(user);
			MANAGER.getTransaction().commit();
			MANAGER.close();
		} catch (Exception e) {
			throw new CustomException("Failed to add Student");
		}
		return user;
	}
}



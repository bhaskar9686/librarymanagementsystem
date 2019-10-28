package com.capgemini.librarymanagementsystem.dao;

import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Repository
public class StudentDAOImpl implements StudentDAO {
	
	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("LibraryPersistence");
	
	static int bookId;
	static int studentId;
	
	@Override
	public List<BooksInventory> searchBook(BooksInventory booksInventory) throws CustomException {
		List<BooksInventory> booksInventories = null;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			TypedQuery<BooksInventory> query = manager.createQuery("FROM BooksInventory WHERE bookName = :bName and author1 =:author", BooksInventory.class);
			query.setParameter("bName", booksInventory.getBookName());
			query.setParameter("author", booksInventory.getAuthor1());
			booksInventories = query.getResultList();
		} catch (Exception e) {
			throw new CustomException("Failed to fetch the books from BooksInventory");
		}
		return booksInventories;
	}// end of searchBook()
	
	@Override
	public Boolean requestBook(int bookId) throws CustomException {
		BooksRegistration booksRegistration = new BooksRegistration();
		booksRegistration.setId(LoginDAOImpl.id);
		booksRegistration.setBookId(bookId);
		booksRegistration.setRegistrationDate(new Date());
		Random random = new Random();
		booksRegistration.setRegistrationId(random.nextInt(10000));
		StudentDAOImpl.bookId = booksRegistration.getBookId();
		StudentDAOImpl.studentId = booksRegistration.getId();
		boolean isRequested = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(booksRegistration);
			manager.getTransaction().commit();
			isRequested = true;
			manager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to Request the Book");
		}
		return isRequested;
	}// end of requestBook()

	@Override
	public List<BooksTransaction> requestStatus(int id) throws CustomException {
		List<BooksTransaction> booksTransactions = null;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			TypedQuery<BooksTransaction> typedQuery = manager.createQuery("FROM BooksTransaction WHERE id =:id", BooksTransaction.class);
			typedQuery.setParameter("id", id);
			booksTransactions = typedQuery.getResultList();
		} catch (Exception e) {
			throw new CustomException("Failed to fetch the requestStatus");
		}
		return booksTransactions;
	}// end of requestStatus()

}

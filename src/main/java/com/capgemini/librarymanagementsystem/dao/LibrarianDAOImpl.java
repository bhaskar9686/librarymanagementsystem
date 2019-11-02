package com.capgemini.librarymanagementsystem.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

@Repository
public class LibrarianDAOImpl implements LibrarianDAO {

	@PersistenceUnit
	private EntityManagerFactory FACTORY;

	@Override
	public Users registerStudent(Users user) throws LibraryManagementSystemException {
		user.setType("Student");
		Random random = new Random();
		user.setId(random.nextInt(10000));
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(user);
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to add Student");
		}
		return user;
	}// end of registerStudent()

	@Override
	public Users getStudentInfo(int id) throws LibraryManagementSystemException {
		Users users = null;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			users = manager.find(Users.class, id);
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to fetch the Student Info");
		}
		return users;
	}// end of getStudentInfo()

	@Override
	public Boolean deleteStudent(int id) throws LibraryManagementSystemException {
		boolean isDeleted = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			Users users = manager.find(Users.class, id);
			manager.remove(users);
			manager.getTransaction().commit();
			isDeleted = true;
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to delete the Student");
		}
		return isDeleted;
	}// end of deleteStudent()

	@Override
	public List<BooksRegistration> viewRequest() throws LibraryManagementSystemException {
		List<BooksRegistration> booksRegistrations = null;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			TypedQuery<BooksRegistration> typedQuery = manager.createQuery("FROM BooksRegistration",
					BooksRegistration.class);
			booksRegistrations = typedQuery.getResultList();
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to Fetch the Requests");
		}
		return booksRegistrations;
	}// end of viewRequest()

	@Override
	public BooksTransaction acceptRequest(int registrationId) throws LibraryManagementSystemException {
		BooksTransaction booksTransaction = new BooksTransaction();
		Random random = new Random();
		LocalDate issueDate = LocalDate.now();
		LocalDate returnDate = issueDate.plusDays(14);

		booksTransaction.setTransactionId(random.nextInt(10000));
		booksTransaction.setIssueDate(issueDate);
		booksTransaction.setRegistrationId(registrationId);
		booksTransaction.setReturnDate(returnDate);
		booksTransaction.setBookId(StudentDAOImpl.bookId);
		booksTransaction.setId(StudentDAOImpl.studentId);

		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(booksTransaction);
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to accept to Request");
		}
		return booksTransaction;
	}// end of acceptRequest()

	@Override
	public Boolean denyRequest(int registrationId) throws LibraryManagementSystemException {
		boolean isDenyed = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			BooksRegistration bookRegistration = manager.find(BooksRegistration.class, registrationId);
			manager.remove(bookRegistration);
			manager.getTransaction().commit();
			isDenyed = true;
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to Deny the Request");
		}
		return isDenyed;
	}// end of denyRequest()

	@Override
	public Boolean returnBook(int id) throws LibraryManagementSystemException {
		boolean isReturned = false;
		BooksTransaction booksTransaction = null;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<BooksTransaction> typedQuery = manager.createQuery("FROM BooksTransaction WHERE id = :id",
					BooksTransaction.class);
			typedQuery.setParameter("id", id);
			booksTransaction = typedQuery.getSingleResult();
			manager.remove(booksTransaction);
			manager.getTransaction().commit();
			isReturned = true;
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to Return the Book");
		}
		return isReturned;
	}// end of returnBook()

	@Override
	public BooksTransaction getIssuedBookInfo(int id) throws LibraryManagementSystemException {
		BooksTransaction booksTransaction = null;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			TypedQuery<BooksTransaction> typedQuery = manager.createQuery("FROM BooksTransaction WHERE id = :id",
					BooksTransaction.class);
			typedQuery.setParameter("id", id);
			booksTransaction = typedQuery.getSingleResult();
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to fetch the Issued Book Info");
		}
		return booksTransaction;
	}// end of getIssuedBookInfo()

	@Override
	public List<BooksTransaction> issuedBooks() throws LibraryManagementSystemException {
		List<BooksTransaction> booksTransactions = null;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			TypedQuery<BooksTransaction> typedQuery = manager.createQuery("FROM BooksTransaction",
					BooksTransaction.class);
			booksTransactions = typedQuery.getResultList();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to fetch the issued Books");
		}
		return booksTransactions;
	}// end of issuedBook()

	@Override
	public Boolean addBooks(BooksInventory booksInventory) throws LibraryManagementSystemException {
		boolean isAdded = false;
		Random random = new Random();
		booksInventory.setBookId(random.nextInt(10000));
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(booksInventory);
			manager.getTransaction().commit();
			isAdded = true;
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to add the book");
		}
		return isAdded;
	}// end of addBooks()

	@Override
	public Boolean deleteBook(int bookId) throws LibraryManagementSystemException {
		boolean isDeleted = false;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			manager.getTransaction().begin();
			BooksInventory booksInventory = manager.find(BooksInventory.class, bookId);
			manager.remove(booksInventory);
			manager.getTransaction().commit();
			isDeleted = true;
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to delete the book from BooksInventory");
		}
		return isDeleted;
	}// end of deleteBook()

	@Override
	public List<BooksInventory> showAllBooks() throws LibraryManagementSystemException {
		List<BooksInventory> booksInventories = null;
		try {
			EntityManager manager = FACTORY.createEntityManager();
			TypedQuery<BooksInventory> query = manager.createQuery("FROM BooksInventory", BooksInventory.class);
			booksInventories = query.getResultList();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to fetch the books from BooksInventory");
		}
		return booksInventories;
	}// end of showAllBook()

}

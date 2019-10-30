package com.capgemini.librarymanagementsystem.dao;

import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

@Repository
public class AdminDaoImpl implements AdminDAO {
	@PersistenceUnit
	private EntityManagerFactory factory ;
	@Override
	public Users addLibrarian(Users users) throws LibraryManagementSystemException {
		users.setType("Librarian");
		Random random = new Random();
		users.setId(random.nextInt(10000));
		try {
			EntityManager manager = factory.createEntityManager();
			manager.getTransaction().begin();
			manager.persist(users);
			manager.getTransaction().commit();
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to add Librarin");
		}
		return users;
	}// end of addLibrarian()

	@Override
	public Boolean deleteLibrarian(int id) throws LibraryManagementSystemException {
		boolean isDeleted = false;
		try {
			EntityManager manager = factory.createEntityManager();
			Users user = manager.find(Users.class, id);
			manager.getTransaction().begin();
			manager.remove(user);
			manager.getTransaction().commit();
			isDeleted = true;
			manager.close();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("Failed to Delete Librarin");
		}
		return isDeleted;
	}// end of deleteLibrarian()

	@Override
	public List<Users> displayLibrarian() throws LibraryManagementSystemException {
		List<Users> userList = null;
		 try {
			 EntityManager manager = factory.createEntityManager();
			TypedQuery<Users> typedQuery = manager.createQuery("FROM Users WHERE type = 'Librarian'", Users.class);
			 userList = typedQuery.getResultList();
		} catch (Exception e) {
			throw new LibraryManagementSystemException("No Data Found");
		}
		return userList;
	}// end of displayLibrarian()

}

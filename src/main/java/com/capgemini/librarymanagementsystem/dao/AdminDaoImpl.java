package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Repository
public class AdminDaoImpl implements AdminDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("LibraryPersistence");
	static final EntityManager MANAGER = FACTORY.createEntityManager();

	@Override
	public Users addLibrarian(Users users) throws CustomException {
		try {
			MANAGER.getTransaction().begin();
			MANAGER.persist(users);
			MANAGER.getTransaction().commit(); 
			MANAGER.close();
		} catch (Exception e) {
			throw new CustomException("Failed to add Librarin");
		}
		return users;
	}

	@Override
	public Boolean deleteLibrarian(int id) throws CustomException {
		boolean isDeleted = false;
		try {
			Users user = MANAGER.find(Users.class, id);
			MANAGER.getTransaction().begin();
			MANAGER.remove(user);
			MANAGER.getTransaction().commit();
			MANAGER.close();
		} catch (Exception e) {
			throw new CustomException("Failed to Delete Librarin");
		}
		return isDeleted;
	}

	@Override
	public List<Users> displayLibrarian() throws CustomException {

		List<Users> userList = null;
		try {
			TypedQuery<Users> typedQuery = MANAGER.createQuery("FROM Users WHERE type = 'librarian'", Users.class);
			userList = typedQuery.getResultList();
		} catch (Exception e) {
			throw new CustomException("No Data Found");
		}
		return userList;
	}

}

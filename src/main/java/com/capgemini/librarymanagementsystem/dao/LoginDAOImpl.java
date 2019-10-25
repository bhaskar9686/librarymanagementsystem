package com.capgemini.librarymanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Repository
public class LoginDAOImpl implements LoginDAO {

	static final EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("LibraryPersistence");
	static final EntityManager MANAGER = FACTORY.createEntityManager();
	@Override
	public Users login(int id, String password) throws CustomException {
		Users user = null;
		try {
			Query query = MANAGER.createQuery("FROM Users WHERE id= :id, and password=:pswd");
			query.setParameter("id", id);
			query.setParameter("pswd", password);
			user = (Users)query.getSingleResult();
		} catch (Exception e) {
			throw new CustomException("Login Failed");
		}
		return user;
	}

}

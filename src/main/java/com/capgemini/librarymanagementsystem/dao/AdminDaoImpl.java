package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public class AdminDaoImpl implements AdminDAO {
	
	private static EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("DemoPersistence");

	@Override
	public Users addLibrarian(Users users) throws CustomException {
		
		
		try {
			EntityManager entityManager=entityManagerFactory.createEntityManager();
			EntityTransaction entityTransaction=entityManager.getTransaction();
			entityTransaction.begin();
			entityManager.persist(users);
			entityTransaction.commit();
			entityManager.close();
		} catch (Exception e) {
			throw new CustomException("Failed to add Librarin");
		}
		return users;
	}

	@Override
	public Boolean deleteLibrarian(int userId) {
		return null;
	}

	@Override
	public List<Users> displayLibrarian() {
		return null;
	}

}

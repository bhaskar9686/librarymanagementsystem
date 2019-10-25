package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public class AdminServicesImpl implements AdminServices{
	
	@Autowired
	AdminDAO dao;

	@Override
	public Users addLibrarian(Users users) throws CustomException {
		return dao.addLibrarian(users);
	}

	@Override
	public Boolean deleteLibrarian(int id) throws CustomException {
		return dao.deleteLibrarian(id);
	}

	@Override
	public List<Users> displayLibrarian() throws CustomException {
		return dao.displayLibrarian();
	}

}

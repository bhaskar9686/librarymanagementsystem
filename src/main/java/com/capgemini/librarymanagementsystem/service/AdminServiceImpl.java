package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDAO dao;

	@Override
	public Users addLibrarian(Users users) throws LibraryManagementSystemException {
		return dao.addLibrarian(users);
	}// end of addLibrarian()

	@Override
	public Boolean deleteLibrarian(int id) throws LibraryManagementSystemException {
		return dao.deleteLibrarian(id);
	}// end of deleteLibrarian()

	@Override
	public List<Users> displayLibrarian() throws LibraryManagementSystemException {
		return dao.displayLibrarian();
	}// end of displayLibrarian()

}

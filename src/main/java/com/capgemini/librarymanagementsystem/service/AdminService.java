package com.capgemini.librarymanagementsystem.service;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

public interface AdminService {

	public Users addLibrarian(Users users) throws LibraryManagementSystemException;

	public Boolean deleteLibrarian(int id) throws LibraryManagementSystemException;

	public List<Users> displayLibrarian() throws LibraryManagementSystemException;

}

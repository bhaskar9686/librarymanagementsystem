package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

public interface AdminDAO {

	public Users addLibrarian(Users users) throws LibraryManagementSystemException;

	public Boolean deleteLibrarian(int id) throws LibraryManagementSystemException;

	public List<Users> displayLibrarian() throws LibraryManagementSystemException;

}

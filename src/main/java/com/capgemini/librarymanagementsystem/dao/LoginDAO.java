package com.capgemini.librarymanagementsystem.dao;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

public interface LoginDAO {

	public Users login(Users users) throws LibraryManagementSystemException ;
}

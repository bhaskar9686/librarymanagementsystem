package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;



/*
 * 
 * author Bhaskar VA 
 * 
 */


public interface LoginService {

	public Users login(Users users) throws LibraryManagementSystemException ;
}

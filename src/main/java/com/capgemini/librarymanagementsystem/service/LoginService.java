package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

public interface LoginService {

	public Users login(Users users) throws LibraryManagementSystemException ;
}

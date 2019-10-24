package com.capgemini.librarymanagementsystem.service;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface LoginService {

	public Users login(int id, String password) throws CustomException;
}

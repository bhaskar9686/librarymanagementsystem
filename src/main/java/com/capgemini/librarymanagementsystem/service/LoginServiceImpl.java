package com.capgemini.librarymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.LoginDAO;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO dao;
	
	@Override
	public Users login(Users users) throws CustomException {
		return dao.login(users);
	}// end of login()

}

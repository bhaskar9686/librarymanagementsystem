package com.capgemini.librarymanagementsystem.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public class AdminServicesImpl implements AdminServices{
	
	@Autowired
	AdminDAO dao;

	@Override
	public Users addLibrarian(Users users) throws CustomException {
		
		Pattern pattern = Pattern.compile("\\w+\\@\\w+\\.\\w+");
		Matcher matcher = pattern.matcher(users.getEmail());
		Pattern pattern1 = Pattern.compile("\\w+\\@\\d+");
		Matcher matcher1 = pattern1.matcher(users.getPassword());
		if(matcher.matches() && matcher1.matches()){
			return users;
		}
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

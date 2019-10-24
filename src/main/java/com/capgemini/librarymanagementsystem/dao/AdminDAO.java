package com.capgemini.librarymanagementsystem.dao;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;

public interface AdminDAO {

	public Users addLibrarian(Users users)  throws CustomException;
	
	public Boolean deleteLibrarian(int userId);
	
	public List<Users> displayLibrarian();
	
	
	
}

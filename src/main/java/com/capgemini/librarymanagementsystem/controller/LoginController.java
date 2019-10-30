package com.capgemini.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.response.UsersResponse;
import com.capgemini.librarymanagementsystem.service.LoginService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

	@Autowired
	private LoginService service;

	@PostMapping("/lims/login/")
	public UsersResponse login(@RequestBody Users users) {
		UsersResponse response = new UsersResponse();
		Users user = null;
		try {
			user = service.login(users);
			if(user!=null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("User Login Successfull");
				response.setUsers(user);
			} else
			{
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Login");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of login()

}

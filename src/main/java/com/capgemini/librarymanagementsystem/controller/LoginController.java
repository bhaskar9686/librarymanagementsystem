package com.capgemini.librarymanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;
import com.capgemini.librarymanagementsystem.service.LoginService;

@RestController
public class LoginController {
	
	@Autowired
	LoginService service;
	@PostMapping("/lims/login/{id}/{password}")
	public Users login(@PathVariable("id") int id, @PathVariable("password") String password) throws CustomException {
		Users user = null;
		user = service.login(id, password);
		return user;
	}// end of login()

}

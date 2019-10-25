package com.capgemini.librarymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.exceptions.CustomException;
import com.capgemini.librarymanagementsystem.service.AdminServices;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
public class AdminController {
	@Autowired
	AdminServices service;
	
	@PostMapping("/lims/admin/create")
	public Users addLibrarian(@RequestBody Users users) {
		try {
			users = service.addLibrarian(users);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return users;
	}// end of addLibrarian()
	
	@DeleteMapping("lims/admin/deleteLibrarian/{id}")
	public Boolean deleteLibrarian(@PathVariable ("id") int id) {
		boolean isDeleted = false;
		try {
			isDeleted = service.deleteLibrarian(id);
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return isDeleted;
	}// end of deleteLibrarian()
	
	@GetMapping("lims/admin/displayLibrarian")
	public List<Users> displayeLibrarian(){
		List<Users> usersList = null;
		try {
			usersList = service.displayLibrarian();
		} catch (CustomException e) {
			System.err.println(e.getMessage());
		}
		return usersList;
	}// end of displayeLibrarian()
	
}


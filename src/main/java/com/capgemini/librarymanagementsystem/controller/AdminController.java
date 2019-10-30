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
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;
import com.capgemini.librarymanagementsystem.response.UsersResponse;
import com.capgemini.librarymanagementsystem.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
	@Autowired
	private AdminService service;

	@PostMapping("/lims/admin/create")
	public UsersResponse addLibrarian(@RequestBody Users users) {
		UsersResponse response = new UsersResponse();
		try {
			users = service.addLibrarian(users);
			if(users!=null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("User Added Successfully");
				response.setUsers(users);
			} else
			{
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Add User");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of addLibrarian()

	@DeleteMapping("lims/admin/deleteLibrarian/{id}")
	public UsersResponse deleteLibrarian(@PathVariable("id") int id) {
		UsersResponse response = new UsersResponse();
		try {
			if(service.deleteLibrarian(id)) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("User Deleted Successfully");
			} else
			{
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to Delete User");
			}
			
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of deleteLibrarian()

	@GetMapping("lims/admin/displayLibrarian")
	public UsersResponse displayeLibrarian() {
		UsersResponse response = new UsersResponse();
		List<Users> usersList = null;
		try {
			usersList = service.displayLibrarian();
			if(usersList!=null) {
				response.setStatus("201");
				response.setMessage("Success");
				response.setDescription("User Details Fetched Successfully");
				response.setUserList(usersList);
			} else
			{
				response.setStatus("400");
				response.setMessage("Failed");
				response.setDescription("Failed to fetch the User Details");
			}
		} catch (LibraryManagementSystemException e) {
			System.err.println(e.getMessage());
		}
		return response;
	}// end of displayeLibrarian()

}

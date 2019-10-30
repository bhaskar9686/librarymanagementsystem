package com.capgemini.librarymanagementsystem.response;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.Users;

public class UsersResponse {

	private String status;
	private String message;
	private String description;
	
	private Users users;
	private List<Users> userList;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public List<Users> getUserList() {
		return userList;
	}
	public void setUserList(List<Users> userList) {
		this.userList = userList;
	}
	
}

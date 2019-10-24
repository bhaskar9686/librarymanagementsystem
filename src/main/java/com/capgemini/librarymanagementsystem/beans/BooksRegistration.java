package com.capgemini.librarymanagementsystem.beans;

import java.util.Date;

public class BooksRegistration {
	
	
	private int registrationId;
	
	private int bookId;
	
	private int userId;
	
	private Date registrationDate;

	public int getRegistrationId() {
		return registrationId;
	}

	public void setRegistrationId(int registrationId) {
		this.registrationId = registrationId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public String toString() {
		return "BooksRegistration [registrationId=" + registrationId + ", bookId=" + bookId + ", userId=" + userId
				+ ", registrationDate=" + registrationDate + "]";
	}
	
	

}

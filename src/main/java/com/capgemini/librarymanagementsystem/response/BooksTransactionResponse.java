package com.capgemini.librarymanagementsystem.response;

import java.util.List;

import com.capgemini.librarymanagementsystem.beans.BooksTransaction;

public class BooksTransactionResponse {
	private String status;
	private String message;
	private String description;
	private BooksTransaction booksTransaction;
	private List<BooksTransaction> transactionList;
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
	public BooksTransaction getBooksTransaction() {
		return booksTransaction;
	}
	public void setBooksTransaction(BooksTransaction booksTransaction) {
		this.booksTransaction = booksTransaction;
	}
	public List<BooksTransaction> getTransactionList() {
		return transactionList;
	}
	public void setTransactionList(List<BooksTransaction> transactionList) {
		this.transactionList = transactionList;
	}
}

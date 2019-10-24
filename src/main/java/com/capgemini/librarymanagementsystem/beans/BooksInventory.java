package com.capgemini.librarymanagementsystem.beans;

public class BooksInventory {
	
	private int bookId;
	
	private String bookName;
	
	private String author;
	
	private String author1;
	
	private String publisher;
	
	private String yearOfPublication;

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor1() {
		return author1;
	}

	public void setAuthor1(String author1) {
		this.author1 = author1;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public String getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(String yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}

	@Override
	public String toString() {
		return "BooksInventory [bookId=" + bookId + ", bookName=" + bookName + ", author=" + author + ", author1="
				+ author1 + ", publisher=" + publisher + ", yearOfPublication=" + yearOfPublication + "]";
	}
	
	
	
	
	

}

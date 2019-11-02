package com.capgemini.librarymanagementsystem;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.librarymanagementsystem.beans.BooksInventory;
import com.capgemini.librarymanagementsystem.beans.BooksRegistration;
import com.capgemini.librarymanagementsystem.beans.BooksTransaction;
import com.capgemini.librarymanagementsystem.beans.Users;
import com.capgemini.librarymanagementsystem.dao.AdminDAO;
import com.capgemini.librarymanagementsystem.dao.LibrarianDAO;
import com.capgemini.librarymanagementsystem.dao.LoginDAO;
import com.capgemini.librarymanagementsystem.dao.StudentDAO;
import com.capgemini.librarymanagementsystem.exceptions.LibraryManagementSystemException;

@SpringBootTest
public class LibraryManagementTest {



	@Autowired
	private AdminDAO admin;

	@Autowired
	private LibrarianDAO lib;

	@Autowired
	private StudentDAO student;

	@Autowired
	private LoginDAO loginDAO;



	@Test
	void testDel() {
		boolean check = false;
		try {
			check = admin.deleteLibrarian(2);// id
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}

	@Test
	void testAdd() {
		Users user=new Users();
		user.setEmail("richi@gmail.com");
		user.setPassword("std12345");
		user.setType("student");
		user.setId(103);
		user.setName("Richi");
		Users users=new Users();
		users.setEmail("bitan@gmail.com");
		users.setPassword("std12345");
		users.setType("student");
		users.setId(103);
		users.setName("Richi");
		user.equals(users);
		try {
			user=admin.addLibrarian(user);
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
	}




	@Test
	void testShowAllUser() {
		List<Users> userList = null;
		try {
			userList = admin.displayLibrarian();
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertNotNull(userList);
	}



	@Test
	public void testDelBook() {
		boolean check = false;
		try {
			check = lib.deleteBook(100);
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}

	@Test
	void testAddBook() {
		BooksInventory book=new BooksInventory();
		book.setAuthor1("Ram vilas");
		book.setAuthor2("Kumar j");
		book.setBookId(1); //have to give bookid
		book.setBookName("How to read a book");
		book.setPublisher("MNO");
		book.setYearOfPublication("2019-11-11"); //
		boolean check = false;
		try {
			check = lib.addBooks(book);
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}



	@Test
	void testShowAllIssuedBooks() {
		List<BooksTransaction> bookList = null;
		try {
			bookList = lib.issuedBooks();
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertNotNull(bookList);
	}

	@Test
	void testShowAllIssueBooks() {
		BooksTransaction bookList = null;

		try {
			bookList = lib.getIssuedBookInfo(1);
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertNotNull(bookList);
	}

	@Test
	void testAcceptRequest() {
		BooksTransaction book = null;
		try {
			book = lib.acceptRequest(1); // we have to pass valid id
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertNotNull(book);
	}

	@Test
	void testShowAllRequests() {
		List<BooksRegistration> book = null;
		try {
			book = lib.viewRequest();
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertNotNull(book);
	}

	@Test
	void testReturnBook() {
		Boolean book=null;
		try {
			book=lib.returnBook(1);// we have to give valid id
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		} 

		assertNotNull(book);
	}

	@Test
	void testRequestBook() {
		BooksInventory book=new BooksInventory();
		book.setAuthor1("Ram vilas");
		book.setAuthor2("Kumar j");
		book.setBookId(125); // we have to give valid
		book.setBookName("How to read a book");
		book.setPublisher("MNO");
		book.setYearOfPublication("2019-11-11");
		boolean check = false;
		try {
			check = student.requestBook(100);//valid
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertTrue(check);
	}


	@Test
	void testLogin() {
		Users user = new Users();
		user.setId(100);
		user.setPassword("bhaskar123");
		Users check = null;
		try {
			check = loginDAO.login(user);
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}

		assertNotNull(user);
	}

	@Test
	void testShowAllBooks() {
		List<BooksInventory> books= null;
		try {
			books = lib.showAllBooks();
		} catch (LibraryManagementSystemException e) {
			e.printStackTrace();
		}
		assertNotNull(books);
	}

}







package kr.ac.kopo.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book implements Serializable {
	
	private static final long serialVersionUID = 8915032889366284259L;
			
	private String isbn;
	private String bookName;
	private String writer;
	private String publisher;
	private String genre;
	private String rental;
	private String rentalDate;
		
	private static List<Book> bookInfo = new ArrayList<Book>();
	
	public Book() {
		
	}
	
	public Book(String isbn, String bookName, String writer, String publisher, String genre) {
		this.isbn = isbn;
		this.bookName = bookName;
		this.writer = writer;
		this.publisher = publisher;
		this.genre = genre;
		this.rental = "대출 가능";
		this.rentalDate = null;
	}

	public String getIsbn() {
		return isbn;
	}

	public String getBookName() {
		return bookName;
	}


	public String getWriter() {
		return writer;
	}


	public String getPublisher() {
		return publisher;
	}


	public String getGenre() {
		return genre;
	}

	
	public String getRental() {
		return rental;
	}
	

	public void setRental(String rental) {
		this.rental = rental;
	}
	
	public String getRentalDate() {
		return rentalDate;
	}

	public void setRentalDate(String rentalDate) {
		this.rentalDate = rentalDate;
	}

	public static List<Book> getBookInfo() {
		return bookInfo;
	}

	public static void setBookInfo(List<Book> bookInfo) {
		Book.bookInfo = bookInfo;
	}


} 

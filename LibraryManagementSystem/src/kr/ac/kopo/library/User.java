package kr.ac.kopo.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Serializable{
	
	private String id;
	private String password;
	private Map<String, Book> rentalBook = new HashMap();	// 회원의 도서 대여 내역 조회
	// In memory 버전
	// public static Map<String, User> currentUser = new HashMap();	// 현재 가입한 회원 저장
	
	public User() {
		
	}
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}
	
	public Map<String, Book> getRentalBook() {
		return rentalBook;
	}

	public void addRentalHistory(String isbn, Book book) {
		rentalBook.put(isbn, book);
	}
	
	public void removeRentalHistory(String isbn) {
		rentalBook.remove(isbn);
	}



	

	

	
	
}

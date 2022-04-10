package kr.ac.kopo.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import kr.ac.kopo.library.FileIO.LibraryInputSteamImpl;
import kr.ac.kopo.library.FileIO.LibraryOutputStreamImpl;

public class BookServiceImpl implements BookService {
	
	private Scanner sc = new Scanner(System.in); 
	
	private LibraryOutputStreamImpl libraryOutputStreamImpl = new LibraryOutputStreamImpl();
	private LibraryInputSteamImpl libraryInputSteamImpl = new LibraryInputSteamImpl();

	//In memory 버전
	//private List<Book> bookInfo = Book.getBookInfo();
	
	private List<Book> bookInfo = libraryInputSteamImpl.readBook();
	private HashMap<String, Book> rentalBook = new HashMap();
	
	
	// 도서 등록
	@Override
	public void addBook(int n) {	
		for(int i=0; i<n; i++) {
			System.out.println("등록할 도서의 정보를 입력하세요. 도서번호(ISBN)는 중복을 허용하지 않습니다.");
			System.out.print("도서번호(ISBN) : ");
			String isbn = sc.nextLine();
			System.out.print("도서 제목 : ");
			String name = sc.nextLine();
			System.out.print("지은이 : ");
			String writer = sc.nextLine();
			System.out.print("출판사 : ");
			String publisher = sc.nextLine();
			System.out.print("장르 : ");
			String genre = sc.nextLine();
			
			System.out.println();
			Book book = new Book(isbn, name, writer, publisher, genre);
			bookInfo.add(book);	
			libraryOutputStreamImpl.writeBook((ArrayList<Book>) bookInfo);
		}
	
	}
	
	// 도서 목록 조회
	@Override
	public void bookList() {
		bookInfo = libraryInputSteamImpl.readBook();
		for(Book b : bookInfo) {
			System.out.println(b.getIsbn() + "\t\t" + b.getBookName() + "\t" + b.getWriter() + "\t" + b.getPublisher()
								+ "\t" + b.getGenre() + "\t" + b.getRental());	
		}
		
	}
	
	// 도서 검색 
	@Override
	public void bookSearch(int searchType, String keyword) {
		bookInfo = libraryInputSteamImpl.readBook();
		switch (searchType) {
		case 1:	
			for(Book b : bookInfo) {
				if(b.getBookName().equals(keyword)){ 
					System.out.println(b.getIsbn() + "\t\t" + b.getBookName() + "\t" + b.getWriter() + "\t" + b.getPublisher()
					+ "\t" + b.getGenre() + "\t" + b.getRental());
				}
			}
			break;
		case 2:
			for(Book b : bookInfo) {
				if(b.getWriter().equals(keyword)){ 
					System.out.println(b.getIsbn() + "\t\t" + b.getBookName() + "\t" + b.getWriter() + "\t" + b.getPublisher()
					+ "\t" + b.getGenre() + "\t" + b.getRental());
				}
			}
		case 3:
			for(Book b : bookInfo) {
				if(b.getPublisher().equals(keyword)){ 
					System.out.println(b.getIsbn() + "\t\t" + b.getBookName() + "\t" + b.getWriter() + "\t" + b.getPublisher()
					+ "\t" + b.getGenre() + "\t" + b.getRental());
				}
			}
		case 4:
			for(Book b : bookInfo) {
				if(b.getGenre().equals(keyword)){ 
					System.out.println(b.getIsbn() + "\t\t" + b.getBookName() + "\t" + b.getWriter() + "\t" + b.getPublisher()
					+ "\t" + b.getGenre() + "\t" + b.getRental());
				}
			}
		}
	
	}
	
	// 도서 삭제
	@Override
	public void removeBook(String isbn) {
		bookInfo = libraryInputSteamImpl.readBook();
		int cnt = 0;
		for(Book b : bookInfo) {
			if(b.getIsbn().equals(isbn)){ 
				bookInfo.remove(cnt);
				libraryOutputStreamImpl.writeBook((ArrayList<Book>) bookInfo);
				return;
			}
			cnt++;
		}
		
		
	}
	
	// 도서 대출
	@Override
	public void bookRental(String isbn) {
		bookInfo = libraryInputSteamImpl.readBook();	
		int cnt = 0;
		for(Book b : bookInfo) {
			if(b.getIsbn().equals(isbn)) {
				bookInfo.get(cnt).setRental("대출 중");;
				
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				bookInfo.get(cnt).setRentalDate( format.format(new Date()));
				rentalBook.put(isbn, b);
				libraryOutputStreamImpl.writeRentalHistory(rentalBook);
			}
			cnt++;
		}
		libraryOutputStreamImpl.writeBook((ArrayList<Book>) bookInfo);
	}

	// 도서 대출 연장
	@Override
	public void bookRentalExtend(String isbn) {		
		rentalBook = libraryInputSteamImpl.bookRental();
		//Map<String, Book> bookRental = Member.user.getRentalBook();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		
		for(Book b : rentalBook.values()) {
			if(b.getIsbn().equals(isbn)) {
				try {
					date = format.parse(b.getRentalDate());
					cal.setTime(date);
					cal.add(Calendar.DATE, 14);
					rentalBook.get(isbn).setRentalDate(format.format(cal.getTime()));
					libraryOutputStreamImpl.writeRentalHistory(rentalBook);
				} catch (ParseException e) {
					e.printStackTrace();
				}
			}

			
		}
	}
	
	// 도서 반납
	@Override
	public void bookReturn(String isbn) {
		bookInfo = libraryInputSteamImpl.readBook();
		rentalBook = libraryInputSteamImpl.bookRental();
		int cnt =0;
		for(Book b : bookInfo) {
			if(b.getIsbn().equals(isbn)) {
				bookInfo.get(cnt).setRental("대출 가능");
				rentalBook.remove(isbn);
				libraryOutputStreamImpl.writeRentalHistory(rentalBook);		
				libraryOutputStreamImpl.writeBook((ArrayList<Book>) bookInfo);
			}
			cnt++;
		}
	}

}

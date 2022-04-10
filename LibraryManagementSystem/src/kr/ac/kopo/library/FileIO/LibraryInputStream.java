package kr.ac.kopo.library.FileIO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ac.kopo.library.Book;
import kr.ac.kopo.library.Member;
import kr.ac.kopo.library.User;

public interface LibraryInputStream {
	public HashMap<String, String> readManager();
	
	public HashMap<String, String> readMemberLoginInfo();
	
	public List<Member> readMember();
	
	public List<Book> readBook();
	
	public User readUser();
	
	public HashMap<String, Book> bookRental();
}

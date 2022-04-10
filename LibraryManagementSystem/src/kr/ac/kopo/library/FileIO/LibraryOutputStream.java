package kr.ac.kopo.library.FileIO;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ac.kopo.library.Book;
import kr.ac.kopo.library.Member;
import kr.ac.kopo.library.User;

public interface LibraryOutputStream {
	public void writeManager(Map<String, String> managerList);
	
	public void writeMember(ArrayList<Member> MemberInfo);
	
	public void writeMemberLoginInfo(Map<String, String> MemberList);
	 
	public void writeBook(ArrayList<Book> bookList);
	
	public void currentUser(User user);
	
	public void writeRentalHistory(HashMap<String, Book> rentalBook);
	
}

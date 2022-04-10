package kr.ac.kopo.library.FileIO;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import kr.ac.kopo.library.Book;
import kr.ac.kopo.library.Member;
import kr.ac.kopo.library.User;

public class LibraryInputSteamImpl implements LibraryInputStream {
	FileInputStream fis;
	ObjectInputStream ois;

	@SuppressWarnings({ "null", "finally" })
	@Override
	public HashMap<String, String> readManager() {
		try {
			fis = new FileInputStream("LibraryDB/manager.dat");
			HashMap<String, String> managerList = new HashMap<>(); 
							
			try {
				while(true) {
					ois = new ObjectInputStream(fis);
					@SuppressWarnings("unchecked")
					HashMap<String, String> data = (HashMap<String, String>) ois.readObject();
					Set<String> KeySet = data.keySet();
					for(String key : KeySet) {
						managerList.put(key, data.get(key));
					}
				}
			} catch (EOFException e) {	// 파일에 더이상 읽어올 데이터가 없을 경우 에러 발생
				
			}
			return managerList;
		} catch (Exception e) {
			
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				
			}
			
		}
		return null;

	}

	
	@Override
	public HashMap<String, String> readMemberLoginInfo() {
		try {
			fis = new FileInputStream("LibraryDB/memberLoginInfo.dat");
			HashMap<String, String> memberLoginInfo = new HashMap<>(); 
							
			try {
				while(true) {
					ois = new ObjectInputStream(fis);
					@SuppressWarnings("unchecked")
					HashMap<String, String> data = (HashMap<String, String>) ois.readObject();
					Set<String> KeySet = data.keySet();
					for(String key : KeySet) {
						memberLoginInfo.put(key, data.get(key));
					}
				}
			} catch (EOFException e) {	// 파일에 더이상 읽어올 데이터가 없을 경우 에러 발생
				
			}
			return memberLoginInfo;
		} catch (Exception e) {
			
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				
			}
			
		}
		return null;

	}


	@Override
	public List<Member> readMember() {
		try {
			fis = new FileInputStream("LibraryDB/member.dat"); 				
			ois = new ObjectInputStream(fis);			
			ArrayList<Member> member = (ArrayList<Member>) ois.readObject();
		
			return member;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				
			}
			
		}
		return null;
	}


	@Override
	public List<Book> readBook() {
		try {
			fis = new FileInputStream("LibraryDB/book.dat"); 				
			ois = new ObjectInputStream(fis);			
			ArrayList<Book> book = (ArrayList<Book>) ois.readObject();
		
			return book;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				
			}
			
		}
		return null;
	
	}


	@Override
	public User readUser() {
		try {
			fis = new FileInputStream("LibraryDB/user.dat"); 				
			ois = new ObjectInputStream(fis);			
			User user = (User) ois.readObject();
		
			return user;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				
			}
			
		}
		return null;
	}


	@Override
	public HashMap<String, Book> bookRental() {
		try {
			fis = new FileInputStream("LibraryDB/rentalHistory.dat");
			HashMap<String, Book> bookRental = new HashMap<>(); 
							
			try {
				while(true) {
					ois = new ObjectInputStream(fis);
					@SuppressWarnings("unchecked")
					HashMap<String, Book> data = (HashMap<String, Book>) ois.readObject();
					Set<String> KeySet = data.keySet();
					for(String key : KeySet) {
						bookRental.put(key, data.get(key));
					}
				}
			} catch (EOFException e) {	// 파일에 더이상 읽어올 데이터가 없을 경우 에러 발생
				
			}
			return bookRental;
		} catch (Exception e) {
			
		} finally {
			try {
				ois.close();
				fis.close();
			} catch (IOException e) {
				
			}
			
		}
		return null;
	}
	
}

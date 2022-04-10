package kr.ac.kopo.library.FileIO;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.library.Book;
import kr.ac.kopo.library.Member;
import kr.ac.kopo.library.User;

public class LibraryOutputStreamImpl implements LibraryOutputStream{
	FileOutputStream fos;
	ObjectOutputStream oos;
	
	@Override
	public void writeManager(Map<String, String> managerList){
		try {
			fos = new FileOutputStream("LibraryDB/manager.dat",true);
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(managerList);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public void writeMember(ArrayList<Member> MemberInfo) {
		try {
			fos = new FileOutputStream("LibraryDB/member.dat");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(MemberInfo);
			oos.flush();
			
		} catch (Exception e) {
			
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

	}

	@Override
	public void writeMemberLoginInfo(Map<String, String> MemberList) {
		try {
			fos = new FileOutputStream("LibraryDB/memberLoginInfo.dat");
			oos = new ObjectOutputStream(fos);
			Map<String, String> map = new HashMap<String, String>();
			
			for(String key : MemberList.keySet()) {
				map.put(key, MemberList.get(key));	
			}
			
			oos.writeObject(MemberList);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void writeBook(ArrayList<Book> bookList) {
		try {
			fos = new FileOutputStream("LibraryDB/book.dat");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(bookList);
			oos.flush();
			
		} catch (Exception e) {
			
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void currentUser(User user) {
		try {
			fos = new FileOutputStream("LibraryDB/user.dat");
			oos = new ObjectOutputStream(fos);

			oos.writeObject(user);
			oos.flush();
			
		} catch (Exception e) {
			
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

	@Override
	public void writeRentalHistory(HashMap<String, Book> rentalBook) {
		try {
			fos = new FileOutputStream("LibraryDB/rentalHistory.dat");
			oos = new ObjectOutputStream(fos);
			
			oos.writeObject(rentalBook);
			oos.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				oos.close();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}
	

}

package kr.ac.kopo.library;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

import kr.ac.kopo.library.FileIO.LibraryInputSteamImpl;
import kr.ac.kopo.library.FileIO.LibraryOutputStreamImpl;

public class MemberServiceImpl implements MemberService {
	
	// In memory 버전시 사용
	// private List<Member> memberInfo = Member.getMemberInfo(); 
	
	// FileIO 버전
	LibraryInputSteamImpl libraryInputSteamImpl = new LibraryInputSteamImpl();
	LibraryOutputStreamImpl libraryOutputStreamImpl = new LibraryOutputStreamImpl();
	ArrayList<Member> memberInfo;
	private User user;

	// 회원 목록 조회
	@Override
	public void memberList() {	
		memberInfo = (ArrayList<Member>) libraryInputSteamImpl.readMember();
		for(Member m : memberInfo) {
			if(!(m == null)) {
				System.out.println(m.getId() + "\t" + m.getPassword() + "\t\t" + m.getName() + "\t" + m.getPhoneNumber()
				+ "\t\t" + m.getAddress());
			}
			
		}	
	}
	
	// 회원 정보 조회
	@Override
	public void viewMemberInfo() {
		memberInfo = (ArrayList<Member>) libraryInputSteamImpl.readMember();
		user = libraryInputSteamImpl.readUser();
		for(Member m : memberInfo) {
			if(m.getId().equals(user.getId())){				
				System.out.println(m.getId() + "\t" + m.getPassword() + "\t\t" + m.getName() + "\t" + m.getPhoneNumber()
										+ "\t\t" + m.getAddress());
			}
		}
	}
	
	// 회원 정보 수정
	@Override
	public void modifyMemberInfo(int choice, String data) {	
		memberInfo = (ArrayList<Member>) libraryInputSteamImpl.readMember();
		user = libraryInputSteamImpl.readUser();
		int cnt = 0;
		for(Member m : memberInfo) {
			if(m.getId().equals(user.getId())){		
				switch (choice) {
				case 1:
					memberInfo.get(cnt).setPassword(data);
					break;
				case 2:
					memberInfo.get(cnt).setName(data);
					break;
				case 3:
					memberInfo.get(cnt).setPhoneNumber(data);
				case 4:
					memberInfo.get(cnt).setAddress(data);
				}
			}
		}
		libraryOutputStreamImpl.writeMember((ArrayList<Member>)memberInfo);
			
	}

	
	
	//회원탈퇴
	@Override
	public void removeMember() {
		memberInfo = (ArrayList<Member>) libraryInputSteamImpl.readMember();
		Map<String, String> memberList = libraryInputSteamImpl.readMemberLoginInfo();
		user = libraryInputSteamImpl.readUser();
		int cnt = 0;		
		for(Member m : memberInfo) {
			if(m.getId().equals(user.getId())){		
				memberInfo.remove(cnt);
				memberList.remove(m.getId());
				libraryOutputStreamImpl.writeMemberLoginInfo(memberList);
				libraryOutputStreamImpl.currentUser(null);
				libraryOutputStreamImpl.writeMember((ArrayList<Member>)memberInfo);
				return;
			}
			cnt++;
		}
		
	}
	

	@Override
	public void rentalHistory() {	
		Map<String, Book> bookRental = libraryInputSteamImpl.bookRental();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date;
		
		for(Book b : bookRental.values()) {
			try {
				date = format.parse(b.getRentalDate());
				cal.setTime(date);
				cal.add(Calendar.DATE, 14);
				System.out.println(b.getIsbn() + "\t\t" + b.getBookName() + "\t" + b.getWriter() + "\t" + b.getPublisher()
				+ "\t" + b.getGenre() + "\t" + b.getRentalDate() + "\t" + format.format(cal.getTime()));	
			} catch (ParseException e) {
				e.printStackTrace();
			}
			
		}

	}



}

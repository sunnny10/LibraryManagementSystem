package kr.ac.kopo.library;

import java.io.Serializable;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.ac.kopo.library.FileIO.LibraryInputSteamImpl;
import kr.ac.kopo.library.FileIO.LibraryOutputStreamImpl;

public class Member implements SignUpOrLogin, Serializable {
	
	private String id;
	private String password;
	private String phoneNumber;
	private String address;
	private String name;
	public static User user;
	
	transient LibraryOutputStreamImpl libraryOutputStreamImpl = new LibraryOutputStreamImpl();
	transient LibraryInputSteamImpl libraryInputSteamImpl = new LibraryInputSteamImpl();

	private static Map<String, String> memberList = new HashMap<>();
	private static List<Member> memberInfo = new ArrayList<Member>();
	
	private static final long serialVersionUID = -6167134174417771760L;

	
	public Member() {
		
	}
	
	public Member(String id, String password, String name, String phoneNumber, String adderss) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.address = adderss;

	}

	public String getId() {
		return id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public static Map<String, String> getMemberList() {
		return memberList;
	}
	
	public static List<Member> getMemberInfo() {
		return memberInfo;
	}

	public static void setMemberInfo(List<Member> memberInfo) {
		Member.memberInfo = memberInfo;
	}

	@Override
	public boolean signUp(ArrayList<String> info) {
		// 아이디가 중복일 경우 예외발생.
		try {
			memberList.put(info.get(0), info.get(1));
			Member member = new Member(info.get(0), info.get(1), info.get(2), info.get(3), info.get(4));		
			memberInfo.add(member);
			libraryOutputStreamImpl.writeMemberLoginInfo(memberList);
			libraryOutputStreamImpl.writeMember((ArrayList<Member>)memberInfo);
		} catch (Exception e) {
			return false;
		}
		
		return true;	
	}

	@Override
	public boolean login(String id, String password) {
		memberList = libraryInputSteamImpl.readMemberLoginInfo();
		
		if(memberList.containsKey(id) && (memberList.get(id)).equals(password)) {
			
			libraryOutputStreamImpl.currentUser(new User(id, password));
			
			/*if(User.currentUser.containsKey(id)) {
				user = User.currentUser.get(id);
			} else {
				user = new User(id, password);
				User.currentUser.put(id, user);
			}*/

			return true;
		}
		return false;
	}
	
	
}

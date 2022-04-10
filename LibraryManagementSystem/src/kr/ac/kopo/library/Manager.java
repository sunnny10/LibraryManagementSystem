package kr.ac.kopo.library;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kr.ac.kopo.library.FileIO.LibraryInputSteamImpl;
import kr.ac.kopo.library.FileIO.LibraryOutputStreamImpl;

// 관리자 클래스
public class Manager implements SignUpOrLogin, Serializable {

	private String id;
	private String password;
	private Map<String, String> managerList = new HashMap<>();
	
	LibraryOutputStreamImpl libraryOutputStreamImpl = new LibraryOutputStreamImpl();
	LibraryInputSteamImpl libraryInputSteamImpl = new LibraryInputSteamImpl();
	
	public Manager() {
		
	}
	
	public Manager(String id, String password) {
		this.id = id;
		this.password = password;	
	}
	
	@Override
	public boolean signUp(ArrayList<String> info) {	
		id = info.get(0);
		password = info.get(1);
		
		// manager.dat에 저장한 관리자 id를 사용해 중복여부를 체크
		Map<String, String> managerCheck = libraryInputSteamImpl.readManager();
		
		if(managerCheck.containsKey(id) == false) {
			managerList.put(id, password); 
			Manager manager = new Manager(id, password);
			libraryOutputStreamImpl.writeManager(managerList);
		} else {
			return false;
		}
	
		return true;
		
	}

	@Override
	public boolean login(String id, String password) {
		managerList = libraryInputSteamImpl.readManager();
		
		if(managerList.containsKey(id) && (managerList.get(id)).equals(password)) {
			return true;
		}
		return false;		
	}

	

}

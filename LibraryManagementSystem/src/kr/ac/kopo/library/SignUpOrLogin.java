package kr.ac.kopo.library;

import java.util.ArrayList;

// 회원가입, 로그인 기능
public interface SignUpOrLogin {

	public boolean signUp(ArrayList<String> info);
	
	public boolean login(String id, String password);
	
}

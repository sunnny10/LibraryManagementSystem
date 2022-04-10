package kr.ac.kopo.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrintSignUpOrLogin {
	
	private Scanner sc = new Scanner(System.in);
	private String id;
	private String password;
	private ArrayList<String> signUpInfo;
	private Manager manager = new Manager();
	private Member member = new Member();
	
	
	public void printSignUpManager() {
		signUpInfo = new ArrayList<String>();
	
		System.out.println();
		System.out.println("< 관리자 계정 가입창 >");
		
		System.out.print("아이디를 입력하세요 : ");
		id = sc.nextLine();
		signUpInfo.add(id);

		System.out.print("비밀번호를 입력하세요 : ");
		password = sc.nextLine();
		signUpInfo.add(password);
		
		if(!manager.signUp(signUpInfo)) {
			System.out.println("이미 존재하는 아이디입니다. 다시 입력해주세요.");
			printSignUpManager();
		} else {
			System.out.println("\n회원가입이 완료되었습니다.");
		}
	
		System.out.println();
		
	}
	
	public void printSingUpMember() {
		signUpInfo = new ArrayList<String>();
				
		System.out.println();
		System.out.println("< 회원 계정 가입창 >");
		
		System.out.print("아이디를 입력하세요 : ");
		signUpInfo.add(sc.nextLine());

		System.out.print("비밀번호를 입력하세요 : ");
		signUpInfo.add(sc.nextLine());
		
		System.out.print("이름를 입력하세요 : ");
		signUpInfo.add(sc.nextLine());
		
		System.out.print("전화번호를 입력하세요 : ");
		signUpInfo.add(sc.nextLine());

		System.out.print("주소를 입력하세요 : ");
		signUpInfo.add(sc.nextLine());
		
		member = new Member();
		
		if(!member.signUp(signUpInfo)) {
			System.out.println("이미 존재하는 아이디입니다. 다시 입력해주세요.");
			printSingUpMember();
		} else {
			System.out.println("\n회원가입이 완료되었습니다.");
			System.out.println();
			
		}
	}
	
	
	public boolean printLoginManager() {
		System.out.println();
		System.out.println("< 관리자 로그인 >");
		
		System.out.print("아이디를 입력하세요 : ");
		id = sc.nextLine();

		System.out.print("비밀번호를 입력하세요 : ");
		password = sc.nextLine();
		
		if( manager.login(id, password)) {
			System.out.println("로그인 되었습니다.");
			return true;
		}
		
		System.out.println("아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");
		printLoginManager();

		return false;
		
	}
	
	public boolean printLoginMember() {
		System.out.println();
		System.out.println("< 회원 로그인 >");
		
		System.out.print("아이디를 입력하세요 : ");
		id = sc.nextLine();

		System.out.print("비밀번호를 입력하세요 : ");
		password = sc.nextLine();
		
		if( member.login(id, password)) {
			System.out.println("로그인 되었습니다.");
			return true;
		}
		
		System.out.println("아이디 또는 비밀번호를 잘못 입력했습니다. 입력하신 내용을 다시 확인해주세요.");
		printLoginMember();
		
		return false;	
	}

}

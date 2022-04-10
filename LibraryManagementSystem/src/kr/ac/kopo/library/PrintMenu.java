package kr.ac.kopo.library;

import java.util.Scanner;

// 메뉴 선택
public class PrintMenu {
	
	private int select;
	private char yOrn;
	private Scanner sc = new Scanner(System.in);
	private BookServiceImpl bookServiceImpl = new BookServiceImpl();
	private MemberServiceImpl memberServiceImpl = new MemberServiceImpl();

	public void printDescription(){
		System.out.print("사용할 계정 유형을 선택해주세요 (1.회원    2.관리자) : ");
		select = Integer.parseInt(sc.nextLine());
		
		System.out.println();
		SelectAccountType(select);
	}
	
	// 계정 선택
	public void SelectAccountType(int select) {
		if(select == 1) {
			System.out.println("< 회원 계정을 선택하셨습니다. >");
			System.out.print("**로그인이 필요합니다. 회원이 아닐 경우 가입을 해주세요. (1.로그인    2.회원가입) : ");
			selectAccountMenu(select, sc.nextLine());
		} else if(select == 2) {
			System.out.println("< 관리자 계정을 선택하셨습니다. >");
			System.out.print("**로그인이 필요합니다. 관리자가 아닐 경우 가입을 해주세요. (1.로그인    2.관리자가입) : ");
			selectAccountMenu(select, sc.nextLine());
		} else {
			System.out.println("다시 선택해주세요");
			printDescription();
		}
		
		System.out.println();

	}
	
	//회원가입, 로그인 메뉴 선택
	public void selectAccountMenu(int select, String loginOrRegister) {
		PrintSignUpOrLogin printSignUpOrLogin = new PrintSignUpOrLogin();
		
		// 회원 계정
		if(select == 1) {
			if(loginOrRegister.equals("1")) {	// 로그인
				printSignUpOrLogin.printLoginMember();
			} else if(loginOrRegister.equals("2")) {	// 회원가입
				printSignUpOrLogin.printSingUpMember();
				SelectAccountType(1);		
			} else {
				System.out.println("잘못된 입력입니다.");
				SelectAccountType(1);
			}		
		// 관리자
		} else if(select == 2)  {
			if(loginOrRegister.equals("1")) {	// 로그인
				printSignUpOrLogin.printLoginManager();
			} else if(loginOrRegister.equals("2")) {	// 회원가입
				printSignUpOrLogin.printSignUpManager();
				SelectAccountType(2);		
			} else {
				System.out.println("잘못된 입력입니다.");
				SelectAccountType(2);
			}		
			
		}
		
		System.out.println();
		
		if(select == 1) {
			selectMemberMenu();	// 회원 계정의 메뉴
		} else {
			selectManagerMenu();	// 관리자 계정의 메뉴
		}

	}
	
	
	//관리자 계정의 메뉴
	public void selectManagerMenu() {
		System.out.println();
		
		int key = 0;
		System.out.println("< 관리자 계정 >");
		System.out.print("원하는 메뉴를 선택해주세요. (1.회원관리   2.도서관리   3.로그아웃   4.종료) : ");
		key = Integer.parseInt(sc.nextLine());
		System.out.println();
		
		switch (key) {
		case 1:
			System.out.println("< 회원관리 > 메뉴를 선택하셨습니다.");
			System.out.print("원하는 메뉴를 선택해주세요. (1.회원 목록 조회 ) : ");
			memberServiceSubMenu(Integer.parseInt(sc.nextLine()));
			break;
		case 2:
			System.out.println("< 도서관리 > 메뉴를 선택하셨습니다.");
			System.out.print("원하는 메뉴를 선택해주세요. (1.도서 등록    2.도서 목록 조회    3.도서 검색    4.도서 삭제) : ");
			bookServiceSubMenu(Integer.parseInt(sc.nextLine()), "manager");
			break;
		case 3:
			System.out.println("로그아웃 되었습니다.");
			System.out.println();
			printDescription();
			break;
		case 4:
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("                 도서 관리 시스템을 종료합니다");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.exit(0);
		}
		
		System.out.println();
	}
	
	
	// 관리자 계정의 회원관리 서브메뉴
	public void memberServiceSubMenu(int select) {
		System.out.println();
		switch (select) {
		case 1:	// 1. 회원 목록 조회
			System.out.println();
			System.out.println("< 가입한 회원 목록입니다. >");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("ID\t비밀번호\t이름\t\t전화번호\t\t주소");
			System.out.println("------------------------------------------------------------------------------");
			memberServiceImpl.memberList();
			break;
		case 2 : 
			//overdueMemberList();
			break;
		}
		
		System.out.println();
		selectManagerMenu();
		
	}
	

	// 관리자 계정의 도서관리 서브메뉴, 회원 계정의 도서 관련 서브메뉴
	public void bookServiceSubMenu(int select, String type) {		
		switch (select) {
		case 1:	// 1. 도서 등록
			System.out.println("< 도서 등록 >");
			System.out.print("등록할 도서의 권 수를 입력하세요 : ");
			int n = sc.nextInt();
			sc.nextLine();
			bookServiceImpl.addBook(n);
			System.out.println("도서 등록이 완료되었습니다.");
			break;
		case 2:	// 2. 도서 목록 조회
			System.out.println("< 도서 목록 >");
			System.out.println("-----------------------------------------------------------");
			System.out.println("도서번호(ISBN)\t제목\t지은이\t출판사\t장르\t대출 여부");
			System.out.println("-----------------------------------------------------------");
			bookServiceImpl.bookList();
			break;
		case 3:	// 3. 도서 검색
			System.out.println("< 도서 검색  >");
			System.out.print("검색어 유형을 선택하세요. (1.도서 제목    2.지은이    3.출판사    4.장르) : ");
			int searchType = Integer.parseInt(sc.nextLine());
			
			System.out.print("검색어를 입력하세요 : ");
			String keyword = sc.nextLine();
			System.out.println();
			
			System.out.println("------------------------------------------------------------");
			System.out.println("도서번호(ISBN)\t제목\t지은이\t출판사\t장르\t대여 여부");
			System.out.println("------------------------------------------------------------");
			bookServiceImpl.bookSearch(searchType, keyword);
			break;
		case 4:	// 4. 도서 삭제
			System.out.println("< 도서 삭제 >");
			System.out.print("삭제하고자 하는 도서의 도서번호(ISBN)을 입력하세요 : ");
			String isbn = sc.nextLine();
			bookServiceImpl.removeBook(isbn);
			System.out.println("도서가 삭제되었습니다.");
			break;
		}
		
		System.out.println();
		
		if(type.equals("manager")) {
			selectManagerMenu();
		} else {
			selectMemberMenu();
		}	
	}
		
	//회원 계정의 메뉴
	public void selectMemberMenu() {
		Book book = new Book();
		int key = 0;
		System.out.println("< 회원 계정 >");
		System.out.print("원하는 메뉴를 선택해주세요. (1.도서 목록 조회   2.도서 검색   3.도서 대여   4.도서 반납   5.대여 내역 조회   6.마이페이지   7.로그아웃   8.종료) : ");
		key = Integer.parseInt(sc.nextLine());
		System.out.println();
		switch (key) {
		case 1:			
			bookServiceSubMenu(2, "member");
			break;
		case 2:
			
			bookServiceSubMenu(3, "member");
			break;
		case 3:
			System.out.println("< 도서 대여 > 메뉴를 선택하셨습니다.");
			System.out.print("대여할 도서의 도서번호(ISBN)을 입력하세요. : ");
			bookServiceImpl.bookRental(sc.nextLine());
			System.out.println("도서 대여가 완료되었습니다. < 대여 내역 조회 > 메뉴에서 확인하세요.");
			break;
		case 4:
			System.out.println("< 도서 반납 > 메뉴를 선택하셨습니다.");
			System.out.print("반납할 도서의 도서번호(ISBN)을 입력하세요. : ");
			bookServiceImpl.bookReturn(sc.nextLine());
			System.out.println("도서 반납이 완료되었습니다. < 대여 내역 조회 > 메뉴에서 확인하세요.");
			break;
		case 5:
			System.out.println("< 대여 내역 조회 > 메뉴를 선택하였습니다.");
			System.out.println("-------------------------------------------------------------------------------");
			System.out.println("도서번호(ISBN)\t제목\t지은이\t출판사\t장르\t도서 대출 날짜\t도서 반납 날짜");
			System.out.println("-------------------------------------------------------------------------------");
			memberServiceImpl.rentalHistory();
			System.out.println();
			System.out.print("***대여한 도서의 대출 기간을 연장하시겠습니까?(y/n) : ");
			yOrn = sc.nextLine().charAt(0);
			
			if(yOrn == 'y') {
				System.out.print("연장하고 싶은 도서의 도서번호(ISBN)을 입력하세요 : ");
				bookServiceImpl.bookRentalExtend(sc.nextLine());
				System.out.println("연장이 완료되었습니다.");
			} else {
				System.out.println("회원 메뉴로 돌아갑니다.");
			}
			break;
		case 6:
			System.out.println("< 마이페이지 > 메뉴를 선택하였습니다.");
			System.out.print("원하는 메뉴를 선택해주세요. (1.회원 정보 조회/수정  2.회원탈퇴) : ");
			int choice = Integer.parseInt(sc.nextLine());
			memberSubMenu(choice);
			break;
		case 7:
			System.out.println("로그아웃 되었습니다.");
			System.out.println();
			printDescription();
			break;
		case 8:
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.out.println("                                                        도서 관리 시스템을 종료합니다");
			System.out.println("-----------------------------------------------------------------------------------------------------------");
			System.exit(0);
		}
		
		System.out.println();
		if(key != 6) {
			selectMemberMenu();			
		}
		
	}
	
	// 회원 계정의 메뉴 중 마이페이지 서브 메뉴
	public void memberSubMenu(int select) {
		switch (select) {
		case 1:	// 1. 회원 정보 수정
			System.out.println();
			System.out.println("< 나의 정보  >");
			System.out.println("------------------------------------------------------------------------------");
			System.out.println("ID\t비밀번호\t이름\t전화번호\t\t주소");
			System.out.println("------------------------------------------------------------------------------");
			memberServiceImpl.viewMemberInfo();
			
			System.out.println();
			System.out.print("회원 정보를 수정하시겠습니까?(y/n) : ");
			yOrn = sc.nextLine().charAt(0);
			
			if(yOrn == 'y') {
				System.out.print("수정할 정보를 선택하세요. (1.비밀번호    2.이름    3.전화번호    4.주소) : ");
				int choice = Integer.parseInt(sc.nextLine());
				System.out.print("수정할 내용을 작성하세요 : ");
				String data = sc.nextLine();
				memberServiceImpl.modifyMemberInfo(choice, data);
				System.out.println("회원 정보 수정이 완료되었습니다.");
			} else {
				System.out.println("회원 메뉴로 돌아갑니다.");
			}
			break;
		case 2 : // 2. 회원 탈퇴
			System.out.print("***정말로 회원 탈퇴하시겠습니까?(y/n) : ");
			yOrn = sc.nextLine().charAt(0);
			if(yOrn == 'y') {
				memberServiceImpl.removeMember();
				System.out.println("회원 탈퇴가 완료되었습니다.");
				System.out.println();
				printDescription();
			} else {
				System.out.println("회원 메뉴로 돌아갑니다.");
			}
			break;
		}
		
		System.out.println();
		selectMemberMenu();
	
	}

	

	
}

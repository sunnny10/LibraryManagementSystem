package kr.ac.kopo.library;

public class LibrarySystemMain {

	public static void main(String[] args) {
		PrintMenu menu = new PrintMenu();
		
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		System.out.println("                                   도서 관리 시스템을 시작합니다");
		System.out.println("-----------------------------------------------------------------------------------------------------------");
		menu.printDescription();
		
	}

}

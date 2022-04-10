package kr.ac.kopo.library;

public interface BookService {
	public void addBook(int n);
	
	public void bookList();
	
	public void bookSearch(int searchType, String keyword);
	
	public void removeBook(String isbn);
	
	public void bookRental(String isbn);
	
	public void bookRentalExtend(String isbn);
	
	public void bookReturn(String isbn);
}

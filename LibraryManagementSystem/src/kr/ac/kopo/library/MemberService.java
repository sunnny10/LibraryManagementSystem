package kr.ac.kopo.library;

public interface MemberService {
	public void memberList();
	
	public void viewMemberInfo();
	
	public void modifyMemberInfo(int choice, String data);
	
	public void removeMember();
	
	public void rentalHistory();
}

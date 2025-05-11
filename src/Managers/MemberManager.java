package Managers;

import Common.Member;
import Common.commons;
import FileManager.txtFileManager;
import InterFace.IntMember;
import java.io.FileNotFoundException;

public class MemberManager implements IntMember <Member> {
	private txtFileManager member;

	public MemberManager() throws FileNotFoundException {
		member = new txtFileManager("D:\\\\Member.txt");
		member.CreateFile();

	}
	public void insert(Member a) {
		try {
			String B = a.getSttafName() + commons.SPILITTER + a.getMelliCode() + commons.SPILITTER + a.getNumberPhone()
					+ commons.SPILITTER + a.getSttafAddress() + commons.SPILITTER;
			member.appendrow(B);
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found. " + e.getMessage());
		}
	}

	public Member split(String a) {
		String A[] = a.split(commons.SPILITTER);
		Member d = new Member();
		d.setSttafName(A[0]);
		d.setMelliCode(Integer.parseInt(A[1]));
		d.setNumberPhone(Integer.parseInt(A[2]));
		d.setSttafAddress(A[3]);
		return d;
	}

	public Member[] SelectAll() throws FileNotFoundException {
		String A[] = member.getarrayfromfile();
		Member B[] = new Member[A.length];
		for (int x = 0; x < A.length; x++) {
			B[x] = split(A[x]);
		}
		return B;

	}

	public Member[] searchfood(String s) throws FileNotFoundException {
		String B[] = member.getarrayfromfile();
		Member C[] = new Member[B.length];
		int count = 0;
		for (int x = 0; x < B.length; x++) {
			Member member = split(B[x]);
			if (member.getSttafName().equalsIgnoreCase(s))
				C[count++] = member;

		}
		Member D[] = new Member[count];
		System.arraycopy(C, 0, D, 0, count);
		return D;

	}

	public void Deletmember(int rowmember) throws FileNotFoundException {
		if (rowmember <= 0) {
			System.out.println("Error: Invalid row number!");
			return;
		}
	
		String B[] = member.getarrayfromfile();
		StringBuilder d1 = new StringBuilder();
	
		for (int x = 0; x < B.length; x++) {
			if (x != rowmember - 1) { // حذف ردیف مشخص شده
				d1.append(B[x]).append("\n");
			}
		}
	
		member.setintofile(d1.toString().trim()); // حذف فاصله اضافی
	}
	public void updateMember(String newmember, Member updatedMember) throws FileNotFoundException {
		String updatedData = updatedMember.getSttafName() + commons.SPILITTER + updatedMember.getMelliCode()
				+ commons.SPILITTER + updatedMember.getNumberPhone() + commons.SPILITTER
				+ updatedMember.getSttafAddress();
		member.update(newmember, updatedData);
	}

}

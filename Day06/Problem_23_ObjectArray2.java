/*
 * 문제 23 : 객체배열2 
 */
package Day06;

import java.util.Scanner;

public class Problem_23_ObjectArray2 {
	private String name;
	private String tel;
	public Problem_23_ObjectArray2(String name, String tel) {
		this.name=name;
		this.tel=tel;
	}
	public String search(String searchName) {
		if(searchName.equals(name))return tel;
		else return "";
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("인원수 >>");
		int n = scanner.nextInt();
		Problem_23_ObjectArray2 q23[] = new Problem_23_ObjectArray2[n];
		for(int i=0; i<n; i++) {
			System.out.println("이름과 전화번호(번호는 연속적으로 입력)>>");
			String name = scanner.next();
			String tel = scanner.next();
			q23[i]= new Problem_23_ObjectArray2(name,tel);
		}
		System.out.println("저장되었습니다");
		System.out.println("검색 할 이름>>");
		String searchName = scanner.next();
		
		for(int i=0; i<n; i++) {
			if(!q23[i].search(searchName).equals(""))System.out.println(q23[i].search(searchName));
		}
	}
}

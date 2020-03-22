/*
 * 문제 6 : 전화번호부 만들기 
 */
package Day02;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Problem_06_PhoneBook {
	private HashMap<String, String> h = new HashMap<String, String>();
	private Scanner scanner;

	public Problem_06_PhoneBook() {
		while (true) {
			scanner = new Scanner(System.in);
			System.out.println("\n<---전화번호부--->");
			System.out.println("1. 저장");
			System.out.println("2. 삭제");
			System.out.println("3. 목록출력");
			System.out.println("4. 검색");
			System.out.println("5. 파일");
			System.out.println("현재 저장 되어 있는 인원 " + h.size());
			int n = scanner.nextInt();
			switch (n) {
			case 1:
				add();
				break;
			case 2:
				del();
				break;
			case 3:
				print();
				break;
			case 4:
				search();
				break;
			case 5:
				FileWrite_Read();
				break;
			default:
				System.out.println("다시 입력하세요");
			}
		}
	}

	public void add() { // 전화번호부 추가
		System.out.print("이름을 입력하세요 ");
		String n = scanner.next();
		System.out.println("전화번호를 앞자리를 입력하세요");
		String num = scanner.next();
		h.put(n, num);
		System.out.println("저장 완료되었습니다!!");
	}

	public void del() { // 전화번호부 삭제
		System.out.println("삭제할 이름을 입력하세요 ");
		String name = scanner.next();
		h.remove(name);
		System.out.println("삭제 완료 되었습니다 !! ");
	}

	public void print() { // 전화번호부 목록 출력
		Set<String> keys = h.keySet(); // key문자열을 가진 집합 set컬렉션 리턴
		Iterator<String> it = keys.iterator(); // key문자열을 순서대로 접근할 수 있는 iterator 리턴.
		while (it.hasNext()) {
			String key = it.next();
			String telnum = h.get(key);
			System.out.println("이름은  " + key + "  번호는 " + telnum);
		}
		System.out.println("출력 완료되었습니다 !!");
	}

	public void search() { // 전화번호부 검색 출력
		scanner = new Scanner(System.in);
		System.out.println("찾고 싶은 이름 입력하세요");
		String searchName = scanner.next();
		System.out.println("전화번호는 " + h.get(searchName));
		System.out.println("검색 완료되었습니다. !!!");
	}

	public void FileWrite_Read() {
		System.out.println("1. 전화번호부에서 파일에  저장하기");
		System.out.println("2. 파일에서 읽어서 전화번호부에 저장하기");
		int num = scanner.nextInt();
		
		switch (num) {
		case 1:
			try {
				FileWriter fw = new FileWriter("c:\\tel2.txt");
				Set<String> keys = h.keySet(); // key문자열을 가진 집합 set컬렉션 리턴
				Iterator<String> it = keys.iterator(); // key문자열을 순서대로 접근할 수 있는 iterator 리턴.
				while (it.hasNext()) {
					String key = it.next();
					String telnum = h.get(key);
					fw.write(key+" "+telnum+"\r\n");
					System.out.println("파일에 저장완료.");
				}
				fw.close(); // 저장하고 닫기.
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			break;
		case 2:
			String data;
			String arr[];

			try {
				Scanner fs = new Scanner(new File("C:\\tel.txt"));	
				while (fs.hasNextLine()) {
					data = fs.nextLine();		
					arr = data.split(" ");
					h.put(arr[0], arr[1]);
				}
				System.out.println("파일 전송완료..");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;
		}
	}

	public static void main(String args[]) {
		new Problem_06_PhoneBook();
	}
}

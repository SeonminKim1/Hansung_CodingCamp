/*
 * 문제  36 : 특정 단어로 시작하는 파일검색 
 */
package Day08;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Vector;

public class Problem_36_File_Search {
	private Vector<String> v = new Vector<String>();
	private Iterator<String> it;
	private Scanner scanner;
	private Scanner scan;
	private boolean wordon; // 찾고자 원하는 단어가 있는지 없는지. 이중 while떄문에 씀.

	public Problem_36_File_Search() {
		scan = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("C:\\aa.txt"));
			while (scanner.hasNextLine()) {
				v.add(scanner.nextLine());
			}
			
			while (true) {
				it = v.iterator(); // 이문장을 while문 밖으로 뺴면 안됨. 
				wordon = false;
				System.out.print("찾을 단어를 입력하세요 >>");
				String word = scan.next();
				if (word.equals("exit")) {
					System.exit(0);
					System.out.println("프로그램을 종료합니다...");
				}
				else {
				while (it.hasNext()) {
					String a = it.next();
					if (a.contains(word)) {
						System.out.println(a);
						wordon = true;
					}
				}
				if (wordon == false)
					System.out.println("단어가 없습니다.");
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Problem_36_File_Search();
	}

}

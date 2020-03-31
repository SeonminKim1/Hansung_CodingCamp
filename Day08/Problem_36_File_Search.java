/*
 * ����  36 : Ư�� �ܾ�� �����ϴ� ���ϰ˻� 
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
	private boolean wordon; // ã���� ���ϴ� �ܾ �ִ��� ������. ���� while������ ��.

	public Problem_36_File_Search() {
		scan = new Scanner(System.in);
		try {
			scanner = new Scanner(new File("C:\\aa.txt"));
			while (scanner.hasNextLine()) {
				v.add(scanner.nextLine());
			}
			
			while (true) {
				it = v.iterator(); // �̹����� while�� ������ ���� �ȵ�. 
				wordon = false;
				System.out.print("ã�� �ܾ �Է��ϼ��� >>");
				String word = scan.next();
				if (word.equals("exit")) {
					System.exit(0);
					System.out.println("���α׷��� �����մϴ�...");
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
					System.out.println("�ܾ �����ϴ�.");
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

/*
 * ���� 12 : ���ϰ˻� 
 */
package Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_12_FileSearch {
	private Scanner scanner = new Scanner(System.in);
	private Scanner scan;

	public Problem_12_FileSearch() {
		System.out.println("�ܾ �Է��ϼ���");
		String word = scanner.next();

		System.out.println("������ �����ϼ���");
		String dir = scanner.next();
		System.out.println("1. ��� ���� �˻�, 2. txt���ϸ� �˻�");
		int m = scanner.nextInt();
		File f = new File(dir);
		String filename[] = f.list();

		switch (m) {
		case 1: {	//��� ���� �˻�
			for (int i = 0; i < filename.length; i++) {
				System.out.println(filename[i]);
			}
		}break;
		
		case 2: { 	// txt���ϸ� �˻�
			for (int i = 0; i < filename.length; i++) {
				if (filename[i].contains(".txt")) {
					try {
						scan = new Scanner(new File(dir + filename[i]));
						System.out.println(filename[i] + "�� �ܾ��");
						while (scan.hasNextLine()) {
							String searchword = scan.nextLine();
							if (searchword.contains(word))
								System.out.print(searchword + " ");
						}
						System.out.println();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
		}break;
		}
	}

	public static void main(String[] args) {
		new Problem_12_FileSearch();
	}
}

/*
 * 문제 12 : 파일검색 
 */
package Day03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem_12_FileSearch {
	private Scanner scanner = new Scanner(System.in);
	private Scanner scan;

	public Problem_12_FileSearch() {
		System.out.println("단어를 입력하세요");
		String word = scanner.next();

		System.out.println("폴더를 지정하세요");
		String dir = scanner.next();
		System.out.println("1. 모든 폴더 검색, 2. txt파일만 검색");
		int m = scanner.nextInt();
		File f = new File(dir);
		String filename[] = f.list();

		switch (m) {
		case 1: {	//모든 폴더 검색
			for (int i = 0; i < filename.length; i++) {
				System.out.println(filename[i]);
			}
		}break;
		
		case 2: { 	// txt파일만 검색
			for (int i = 0; i < filename.length; i++) {
				if (filename[i].contains(".txt")) {
					try {
						scan = new Scanner(new File(dir + filename[i]));
						System.out.println(filename[i] + "의 단어들");
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

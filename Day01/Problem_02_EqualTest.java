/*
 * 문제2. 두 개의 정수 배열이 같은지 판별하는 equalInt를 작성하고 두 개의 정수 배열을 만들고 호출하여 판별하라
 */

package Day01;

import java.util.Scanner;

public class Problem_02_EqualTest {
	Scanner scanner;
	public Problem_02_EqualTest() {
		while(true) {
		scanner = new Scanner(System.in);
		System.out.println("첫번째 정수배열 3개짜리 입력해!!");
		int f1[] = new int[3];
		int f2[] = new int[3];
		for(int i=0; i<f1.length; i++) {
			f1[i]=scanner.nextInt();
		}
		System.out.println("두번째 정수배열 3개짜리 입력해!!");
		for(int i=0; i<f2.length; i++) {
			f2[i]=scanner.nextInt();
		}
		if(equallInt(f1,f2))System.out.println("두 배열이 같습니다\n");
		else System.out.println("두 배열이 같지 않습니다\n");
		}
	}
	
	public boolean equallInt(int f1[], int f2[]) {
		for(int i=0; i<f1.length; i++) {
			if(f1[i]!=f2[i])return false;
		}
		return true;
	}
	public static void main(String[] args) {
		new Problem_02_EqualTest();
	}
}

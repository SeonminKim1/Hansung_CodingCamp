/*
 * 문제 19 : 369게임 
 */

package Day05;

import java.util.Scanner;

public class Problem_19_369Game {

	public Problem_19_369Game() {
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("1~99 사이의 정수를 입력하세요");
		int num = scanner.nextInt();
		int frontnum= num/10;
		int backnum = num%10;
		int a = checknum(frontnum,backnum);
		if(a==0)System.out.println("박수없음");
		else if (a==1)System.out.println("박수짝");
		else System.out.println("박수짝짝");
		}
		}
	public int checknum(int n1, int n2) {
		int num=0;
		for(int i=3; i<=9; i=i+3) {
			if(n1==i)num++;
			if(n2==i)num++;
		}
		return num;
	}
	public static void main(String[] args) {
		new Problem_19_369Game();
	}

}

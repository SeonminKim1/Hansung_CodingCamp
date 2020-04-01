/*
 * 문제 50 : 숫자 야구게임 
 */ 

package Day10;

import java.util.Scanner;

public class Problem_50_NumBaseballGame {
	private int num;
	private int n=1; // 시도 횟수
	private Scanner scanner = new Scanner(System.in);
	private int strike,ball,out;
	 
	public Problem_50_NumBaseballGame() {
		num=(int)(Math.random()*899+100);
		System.out.println("숫자 야구게임");
		System.out.println(num);
		while(true) {
			System.out.println("카운트 : "+n);
			System.out.println("1번째 숫자 :");
			int k1 = scanner.nextInt();
			System.out.println("2번째 숫자 :");
			int k2 = scanner.nextInt();
			System.out.println("3번째 숫자 :");
			int k3 = scanner.nextInt();
		
			check(k1,k2,k3);
			if(strike==3) {
				if(n<=2)System.out.println("참 잘했어요");
				else if(n<=5)System.out.println("잘했어요");
				else if(n<=9)System.out.println("보통이네요");
				else System.out.println("분발하세요");
				break;
			}
			n++;
		}
	}
	public void check(int k1, int k2, int k3) {
		int first = num/100;
		int second = (num%100)/10;
		int third = (num%100)%10;
		strike=0; ball=0; out=0;
		if(first==k1)strike++; 
		else if(first==k2 || first==k3)ball++;
		else out++;
		
		if(second==k2)strike++;
		else if(second==k1 || second==k3)ball++;
		else out++;
		
		if(third==k3)strike++;
		else if(third==k1 || third==k2)ball++;
		else out++;
		
		System.out.println("Strike:"+strike+" Ball:"+ball);	
	}

	public static void main(String[] args) {
		new Problem_50_NumBaseballGame();
	}

}

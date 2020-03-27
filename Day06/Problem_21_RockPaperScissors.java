/*
 * 문제  21 : 가위바위보 
 */

package Day06;

import java.util.Scanner;

public class Problem_21_RockPaperScissors {
	public Problem_21_RockPaperScissors() {
		System.out.println("컴퓨터와 가위 바위 보 게임을 합니다.");
		Scanner scanner = new Scanner(System.in);
		while(true) {
		System.out.println("가위 바위 보 !!->");
		String my = scanner.next();
		
		String com[] = {"가위","바위","보"};
		
		String a = com[(int)(Math.random()*2)];
		System.out.println("컴퓨터:"+a+"  사용자:"+my);
		if(a.equals("가위") && my.equals("가위"))System.out.println("비김");
		else if(a.equals("가위") && my.equals("바위"))System.out.println("이김");
		else if(a.equals("가위") && my.equals("보"))System.out.println("짐");
		else if(a.equals("바위") && my.equals("가위"))System.out.println("짐");
		else if(a.equals("바위") && my.equals("바위"))System.out.println("비김");
		else if(a.equals("바위") && my.equals("보"))System.out.println("이김");
		else if(a.equals("보") && my.equals("가위"))System.out.println("이김");
		else if(a.equals("보") && my.equals("바위"))System.out.println("짐");
		else if(a.equals("보") && my.equals("보"))System.out.println("비김");
		else if(my.equals("그만"))break;
		else System.out.println("다시!!");
		}
	}
	public static void main(String[] args) {
		new Problem_21_RockPaperScissors();
	}
}

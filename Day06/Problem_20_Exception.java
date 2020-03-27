/*
 * 문제 20 : 예외처리 
 */

package Day06;

import java.util.Scanner;

public class Problem_20_Exception {
	public Problem_20_Exception() {
		String day[]= {"일","월","화","수","목","금","토"};
		while(true) {
		System.out.println("정수를 입력하세요(0-6)");
		Scanner scanner = new Scanner(System.in);
		String num = scanner.next();
		int n=Integer.parseInt(num);
		if(n<0) {
			System.out.println("종료합니다....");break;
		} 
		else if (n%7>=0 && n%7<7)System.out.println(day[n%7]);
		else System.out.println("경고! 수를 입력하지 않았습니다. !");
		}
	}
	public static void main(String args[]) {
		new Problem_20_Exception();
	}
}
